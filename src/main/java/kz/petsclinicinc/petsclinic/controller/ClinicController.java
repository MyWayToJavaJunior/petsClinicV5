package kz.petsclinicinc.petsclinic.controller;

import kz.petsclinicinc.petsclinic.Clinic;
import kz.petsclinicinc.petsclinic.Person;
import kz.petsclinicinc.petsclinic.Pets.*;
import kz.petsclinicinc.petsclinic.UserException.*;
import kz.petsclinicinc.petsclinic.io.*;

/**
 * ����� - ���������� �����������
 * ��� �������� �������� � ���������
 */
public class ClinicController {

    private final int DEFAULT_CHOICE = 1;

    private boolean on = true;

    Clinic clinic;

    public ClinicController() {
        this.clinic = new Clinic();
    }

    /**
     * ����, � ������� ����������
     * �������� ����, ����������
     * ����� ��� ����� �������������
     * ������ ��������������� ������
     * setOff, ������� ������ ��������
     * ���� on �� false
     */
    public void doWork() {
        while(on) {
            this.MainMenu();
        }
    }

    /**
     * ������� �������� ���� � �������
     * ����� ������������,
     * � ����������� �� ������
     * ��������� ��������������
     * ��������
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
     * ������������ ������ � ������������ ������
     * ������� ����� �������������� ��� ���
     * �������
     * @return ������(��� �������)
     */
    public String askAndGetNameForPerson() {
        IO.askForNamePerson();
        return this.getString();
    }

    /**
     * ������������ ������ � ������������ ������
     * ������� ����� �������������� ��� ���
     * ���������
     * @return ������(��� ���������)
     */
    public String askAndGetNameForPet() {
        IO.askForNamePet();
        return this.getString();
    }

    /**
     * ������� � ������� �������
     * �� ����� ���������
     */
    public void viewByPetName() {
        final String getPetName = this.askAndGetNameForPet();
        final Person getPerson = clinic.getPersonByPetName(getPetName);
        if (getPerson != null) {
            IO.print(getPerson.toString());
        } else IO.NotFound();
    }

    /**
     * ������� � ������� �������
     * �� ����� �������
     */
    public void viewByPersonName() {
        final String getPersonName = this.askAndGetNameForPerson();
        final Person getPerson = clinic.getPersonByName(getPersonName);
        if (getPerson != null) {
            IO.print(getPerson.toString());
        } else IO.NotFound();
    }

    /**
     * ������� ��� ������� � �������
     */
    public void viewAll() {
        for (int i = 0; i < clinic.getPersonsCount(); i++) {
            IO.print(clinic.getPersonById(i).toString());
        }
    }

    /**
     * ������������ ������ � ���� �����
     * ��������� � ��� ����, ����� ����
     * ����� ���������� ���������� ��������
     * @param nameForPet ��� ���������, ����
     * ����������� � �������
     * @return ���������� ���������� �������
     * ��������
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
     * ������������ ������ � ���� ����� �������,
     * ��������� ��������� � ������� ������
     * askAndGetPet(), ����� ���� ����������
     * ����� add() ������ Clinic ��������
     * ����������� ��������� ������
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
     *
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

    public void renByPetName() {
        final String getPetName = this.askAndGetNameForPet();
        final Person getPerson = clinic.getPersonByPetName(getPetName);
        if (getPerson != null) {
            IO.askForNewNamePet();
            getPerson.setPetName(this.getString());
        } else IO.NotFound();
    }

    public void remByPersonName() {
        final String getPersonName = this.askAndGetNameForPerson();
        final Person getPerson = clinic.getPersonByName(getPersonName);
        if (getPerson != null) {
            clinic.remove(getPerson);
        } else IO.NotFound();
    }

    public void remByPetName() {
        final String getPetName = this.askAndGetNameForPet();
        final Person getPerson = clinic.getPersonByPetName(getPetName);
        if (getPerson != null) {
            clinic.remove(getPerson);
        } else IO.NotFound();
    }

    public String getString() {
        return IO.getString();
    }

    public int getChoiceOfTypePet() {
        return this.getSelectedNumber();
    }


    private void setOff() {
        on = false;
    }

    public int getChoiceOfMainMenu() {
        return this.getSelectedNumber();
    }

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
