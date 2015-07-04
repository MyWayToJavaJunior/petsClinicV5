package kz.petsclinicinc.petsclinic.controller;

import kz.petsclinicinc.petsclinic.Clinic;
import kz.petsclinicinc.petsclinic.Person;
import kz.petsclinicinc.petsclinic.Pets.*;
import kz.petsclinicinc.petsclinic.UserException.*;
import kz.petsclinicinc.petsclinic.io.*;

/**
 * Класс - контроллер выполняющий
 * все основные действия в программе
 */
public class ClinicController {

    private final int DEFAULT_CHOICE = 1;

    private boolean on = true;

    Clinic clinic;

    public ClinicController() {
        this.clinic = new Clinic();
    }

    /**
     * Цикл, в котором вызывается
     * основное меню, завершение
     * цикла при вводе пользователем
     * номера соответсвующего методу
     * setOff, который меняет состоние
     * поля on на false
     */
    public void doWork() {
        while(on) {
            this.MainMenu();
        }
    }

    /**
     * Выводит основное меню и ожидает
     * выбор пользователя,
     * в зависимости от выбора
     * выполняет соответсвующую
     * операцию
     */
    public void MainMenu() {
        IO.showMainMenu();
        switch (this.getChoiceOfMainMenu()) {
            default:
            case 1:     this.viewAll();
                        break;
            case 2:     this.add();
                        break;
            case 3:     this.viewByPersonName();
                        break;
            case 4:     this.viewByPetName();
                        break;
            case 5:     this.remByPersonName();
                        break;
            case 6:     this.remByPetName();
                        break;
            case 7:     this.renByPersonName();
                        break;
            case 8:     this.renByPetName();
                        break;
            case 0:     this.setOff();

        }
    }

    /**
     * Производится запрос и возвращается строка
     * которая будет использоваться как имя
     * Персоны
     * @return строка(имя персоны)
     */
    public String askAndGetNameForPerson() {
        IO.askForNamePerson();
        return this.getString();
    }

    /**
     * Производится запрос и возвращается строка
     * которая будет использоваться как имя
     * животного
     * @return строка(имя животного)
     */
    public String askAndGetNameForPet() {
        IO.askForNamePet();
        return this.getString();
    }

    /**
     * Находит и выводит персону
     * по имени животного
     */
    public void viewByPetName() {
        final String getPetName = this.askAndGetNameForPet();
        final Person getPerson = clinic.getPersonByPetName(getPetName);
        if (getPerson != null) {
            IO.print(getPerson.toString());
        } else IO.NotFound();
    }

    /**
     * Находит и выводит персону
     * по имени Персоны
     */
    public void viewByPersonName() {
        final String getPersonName = this.askAndGetNameForPerson();
        final Person getPerson = clinic.getPersonByName(getPersonName);
        if (getPerson != null) {
            IO.print(getPerson.toString());
        } else IO.NotFound();
    }

    /**
     * Выводит все Персоны в клинике
     */
    public void viewAll() {
        for (int i = 0; i < clinic.getPersonsCount(); i++) {
            IO.print(clinic.getPersonById(i).toString());
        }
    }

    /**
     * Производится запрос и получение имени
     * животного и его типа, после чего
     * метод возвращает полученное животное
     * @param nameForPet имя животного, ввод
     * пользоватем с консоли
     * @return возвращает полученное методом
     * животное
     */
    public Pet askAndGetPet(final String nameForPet) {
        IO.askForTypePet();
        Pet resultPet;
        switch (this.getChoiceOfTypePet()) {
            default:
            case 1:     resultPet = new Cat(nameForPet);
                        break;
            case 2:     resultPet = new Bird(nameForPet);
                        break;
            case 3:     resultPet = new Dog(nameForPet);
        }
        return resultPet;
    }

    /**
     * Добавление новой персоны вклинику
     * Производится запрос и получение имени Персоны,
     * методом askAndGetNameForPerson()
     * получение животного с помощью метода
     * askAndGetNameForPet(), после чего вызывается
     * метод add() класса Clinic которому
     * передаеются полченные данные
     */
    public void add() {
        final String nameForPerson = this.askAndGetNameForPerson();
        final String nameForPet = this.askAndGetNameForPet();
        final Pet pet = askAndGetPet(nameForPet);
        try {
            clinic.add(nameForPerson, pet);
        } catch (UserException e) {
            IO.showMsgError(e.getMessage());
        }
    }

    /**
     * Переименование персоны, поиск по имени персоны
     * Производится запрос и получение имени Персоны,
     * методом askAndGetNameForPerson()
     * после чего с помощью метода getPersonByName()
     * класса Clinic по полученному имени Персоны
     * ведется поиск в клинике, если метод не находит Персону
     * с таким именем, то возвращает null, а если находит, то Персоне
     * меняется имя методом renPerson() класса Clinic,
     * новое имя запрашивается методом askForNewNamePerson()
     * получается методом getString()
     */
    public void renByPersonName() {
        final String getPersonName = this.askAndGetNameForPerson();
        final Person getPerson = clinic.getPersonByName(getPersonName);
        if (getPerson != null) {
            IO.askForNewNamePerson();
            try {
                clinic.renPerson(getPerson, this.getString());
            } catch (UserException e) {
                IO.showMsgError(e.getMessage());
            }
        } else IO.NotFound();
    }

    /**
     * Переименование животного, поиск по имени животного
     * Производится запрос и получение имения животного
     * методом askAndGetNameForPet()
     * после чего с помощью метода getPersonByPetName
     * класса Clinic по полученному имени животного
     * ведется поиск в клинике, если метод не находит
     * животное с таким именем - возвращает null,
     * если находит - возвращает персону, по которой
     * потом меняется имя животного методом setPetName()
     * класса Person, новое имя запрашивается и получается
     * методом askForNewNamePet()
     */
    public void renByPetName() {
        final String getPetName = this.askAndGetNameForPet();
        final Person getPerson = clinic.getPersonByPetName(getPetName);
        if (getPerson != null) {
            IO.askForNewNamePet();
            getPerson.setPetName(this.getString());
        } else IO.NotFound();
    }

    /**
     * Удаление персоны по имени. Запрос и получение
     * имени производится методом askAndGetNameForPerson()
     * Затем по полученному имени производится поиск методом
     * getPersonByName() класса Clinic, если метод возвращает
     * не null а персону, то производится её удаление
     * из клиники методом remove() класса Clinic
     */
    public void remByPersonName() {
        final String getPersonName = this.askAndGetNameForPerson();
        final Person getPerson = clinic.getPersonByName(getPersonName);
        if (getPerson != null) {
            clinic.remove(getPerson);
        } else IO.NotFound();
    }

    /**
     * Удаление персоны по имени животного. Запрос
     * и получение имени животного производится методом
     * askAndGetNameForPet() Затем по полученному имени
     * осуществляется поиск в клинике методом getPersonByPetName()
     * класса Clinic, если метод возвращает не null а персону,
     * то производится её удаление из клиники
     */
    public void remByPetName() {
        final String getPetName = this.askAndGetNameForPet();
        final Person getPerson = clinic.getPersonByPetName(getPetName);
        if (getPerson != null) {
            clinic.remove(getPerson);
        } else IO.NotFound();
    }

    /**
     * Получение строки методом
     * getString() класса IO
     * @return строку
     */
    public String getString() {
        return IO.getString();
    }

    /**
     * Получение выбора типа животного
     * методом getSelectedNumber()
     * @return число - выбор пользователя
     */
    public int getChoiceOfTypePet() {
        return this.getSelectedNumber();
    }

    /**
     * Устанавливает состояние поля
     * on в false, используется для
     * выхода и цикла программы
     */
    private void setOff() {
        on = false;
    }

    /**
     * Получение выбора пункта основного
     * меню методом getSelectedNumber()
     * @return число - выбор пользователя
     */
    public int getChoiceOfMainMenu() {
        return this.getSelectedNumber();
    }

    /**
     * Получение числа из строки
     * методом ValueOf() класса-контейнера
     * Integer, полученной методом getString();
     * Перехватывается возможная ошибка
     * наследница класс RuntimeException,
     * что не рекомендуется :)
     * @return выбор пользователя
     * или если пользователь вводит не число
     * дефолтное значение определенное
     * в DEFAULT_CHOICE
     */
    public int getSelectedNumber() {
        int result = this.DEFAULT_CHOICE;
        try {
            result = Integer.valueOf(this.getString());
        } catch (NumberFormatException e) {
            IO.nanInitiatedByDefault();
        }
        return result;
    }
}
