package kz.petsclinicinc.petsclinic;

import kz.petsclinicinc.petsclinic.Pets.Pet;

/**
 * ����� ��� ������ � ��������
 */
public class Person {

    private String nameOfPerson;
    private Pet petOfPerson;

    public Person(final String nameOfPerson, final Pet petOfPerson) {
        this.nameOfPerson = nameOfPerson;
        this.petOfPerson = petOfPerson;
    }

    /**
     * ��� ��������� ��� �������
     * @return ��� �������
     */
    public String getNameOfPerson() {
        return this.nameOfPerson;
    }

    /**
     * ��� ��������� ����� ���������
     * ���������� ����� getNameOfPet()
     * ������ Pet
     * @return ��� ���������
     */
    public String getNameOfPet() {
        return petOfPerson.getNameOfPet();
    }

    /**
     * ��� ����� ����� �������
     * @param newNameOfPerson ����� ��� �������
     */
    public void setName(final String newNameOfPerson) {
        this.nameOfPerson = newNameOfPerson;
    }

    /**
     * ��� ����� ����� ���������
     * ���������� ����� setPetName()
     * ������ Pet
     * @param newNameOfPet ����� ���
     * ���������
     */
    public void setPetName(final String newNameOfPet) {
        this.petOfPerson.setPetName(newNameOfPet);
    }

    /**
     * ��� ��������� ������ �� ��������
     * @return ���������� ������
     * �� ��������
     */
    public Pet getPet() {
        return this.petOfPerson;
    }

    @Override
    public String toString() {
        return "Person: " + this.nameOfPerson + ", " + petOfPerson.toString();
    }
}
