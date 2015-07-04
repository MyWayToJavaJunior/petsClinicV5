package kz.petsclinicinc.petsclinic;

import kz.petsclinicinc.petsclinic.Pets.Pet;
import kz.petsclinicinc.petsclinic.UserException.UserException;

import java.util.ArrayList;

/**
 *  ласс дл€ работы над массивом(коллекцией)
 * ѕерсон
 */
public class Clinic {

    private static final int MAX_SIZE_CLINIC = 100;

    private ArrayList<Person> persons =
            new ArrayList<Person>(MAX_SIZE_CLINIC);

    /**
     * метод который производит непосредственно
     * добавление персон в клинику методом add()
     * коллекции ArrayList
     * @param nameForPerson им€ добавл€емой персоны
     * @param pet животное добовл€емой персоны
     * @throws UserException если клиника уже заполнена
     * или ѕерсона с таким именем уже существует
     */
    public void add(final String nameForPerson, Pet pet) throws UserException {
        if (isClinicFull()) {
            throw new UserException("Clinic full, rem unnecessary persons");
        }
        if (isPersonAlreadyExist(nameForPerson)) {
            throw new UserException("Person Already exist");
        }
        persons.add(new Person(nameForPerson, pet));
    }

    /**
     * ѕолучение текущего количества
     * персон в клинике
     * @return количество персон в
     * клинике
     */
    public int getPersonsCount() {
        return this.persons.size();
    }

    /**
     * ѕолучение персоны по еЄ номеру в коллекции
     * методом get() коллекции ArrayList
     * @param idOfPerson номер персоны в коллекции
     * @return возвращает полученную персону
     */
    public Person getPersonById(int idOfPerson) {
        return persons.get(idOfPerson);
    }

    /**
     * ѕолучение персоны по имени
     * @param nameOfPersonForFind им€
     * ѕерсоны дл€ поиска
     * @return возвращает найденную ѕерсону
     * или null если ѕерсона не найдена
     */
    public Person getPersonByName(final String nameOfPersonForFind) {
        Person resultPerson = null;
        for (Person person : persons)
            if (nameOfPersonForFind.equals(person.getNameOfPerson()))
                resultPerson = person;
        return resultPerson;
    }

    /**
     * ѕолучение персоны по имени животного
     * @param nameOfPetForFind им€ животного
     * дл€ поиска
     * @return возвращает найденную ѕерсону
     * или null если ѕерсона не найдена
     */
    public Person getPersonByPetName(String nameOfPetForFind) {
        Person resultPerson = null;
        for (Person person : persons)
            if (nameOfPetForFind.equals(person.getNameOfPet()))
                resultPerson = person;
        return resultPerson;
    }

    /**
     * удаление персоны из клинки по заданной
     * персоне(или вернее ссылке, как € пон€л)
     * @param personForRemove заданна€ дл€ удалени€
     * персона
     */
    public void remove(Person personForRemove) {
        this.persons.remove(personForRemove);
    }

    /**
     * ѕроверка на заполненность  линики
     * @return возвращает true если в
     * клинике нет мест
     */
    public boolean isClinicFull() {
        return this.getPersonsCount() == MAX_SIZE_CLINIC;
    }

    /**
     * ѕроверка на существование ѕерсоны
     * с заданным именем в клинике
     * @param nameOfPerson им€ дл€ проверки
     * @return возвращает true если персона
     * с заданным именем в клинике уже есть
     */
    public boolean isPersonAlreadyExist(final String nameOfPerson) {
        boolean result = false;
        for (Person person : persons)
            if (nameOfPerson.equals(person.getNameOfPerson()))
                result = true;
        return result;
    }

    public void renPerson(final Person personToRename, final String newNameOfPerson) throws UserException {
        if (isPersonAlreadyExist(newNameOfPerson)) {
            throw new UserException("Person Already exist");
        }
        personToRename.setName(newNameOfPerson);
    }

    /**
     * возвращает максимальное количество мест
     * в клинике
     * @return максимальное количество мест
     */
    public int getMaxSize() {
        return MAX_SIZE_CLINIC;
    }
}
