package kz.petsclinicinc.petsclinic;

import kz.petsclinicinc.petsclinic.Pets.Pet;
import kz.petsclinicinc.petsclinic.UserException.UserException;

import java.util.ArrayList;

/**
 * ����� ��� ������ ��� ��������(����������)
 * ������
 */
public class Clinic {

    private static final int MAX_SIZE_CLINIC = 100;

    private ArrayList<Person> persons =
            new ArrayList<Person>(MAX_SIZE_CLINIC);

    /**
     * ����� ������� ���������� ���������������
     * ���������� ������ � ������� ������� add()
     * ��������� ArrayList
     * @param nameForPerson ��� ����������� �������
     * @param pet �������� ����������� �������
     * @throws UserException ���� ������� ��� ���������
     * ��� ������� � ����� ������ ��� ����������
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
     * ��������� �������� ����������
     * ������ � �������
     * @return ���������� ������ �
     * �������
     */
    public int getPersonsCount() {
        return this.persons.size();
    }

    /**
     * ��������� ������� �� � ������ � ���������
     * ������� get() ��������� ArrayList
     * @param idOfPerson ����� ������� � ���������
     * @return ���������� ���������� �������
     */
    public Person getPersonById(int idOfPerson) {
        return persons.get(idOfPerson);
    }

    /**
     * ��������� ������� �� �����
     * @param nameOfPersonForFind ���
     * ������� ��� ������
     * @return ���������� ��������� �������
     * ��� null ���� ������� �� �������
     */
    public Person getPersonByName(final String nameOfPersonForFind) {
        Person resultPerson = null;
        for (Person person : persons)
            if (nameOfPersonForFind.equals(person.getNameOfPerson()))
                resultPerson = person;
        return resultPerson;
    }

    /**
     * ��������� ������� �� ����� ���������
     * @param nameOfPetForFind ��� ���������
     * ��� ������
     * @return ���������� ��������� �������
     * ��� null ���� ������� �� �������
     */
    public Person getPersonByPetName(String nameOfPetForFind) {
        Person resultPerson = null;
        for (Person person : persons)
            if (nameOfPetForFind.equals(person.getNameOfPet()))
                resultPerson = person;
        return resultPerson;
    }

    /**
     * �������� ������� �� ������ �� ��������
     * �������(��� ������ ������, ��� � �����)
     * @param personForRemove �������� ��� ��������
     * �������
     */
    public void remove(Person personForRemove) {
        this.persons.remove(personForRemove);
    }

    /**
     * �������� �� ������������� �������
     * @return ���������� true ���� �
     * ������� ��� ����
     */
    public boolean isClinicFull() {
        return this.getPersonsCount() == MAX_SIZE_CLINIC;
    }

    /**
     * �������� �� ������������� �������
     * � �������� ������ � �������
     * @param nameOfPerson ��� ��� ��������
     * @return ���������� true ���� �������
     * � �������� ������ � ������� ��� ����
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
     * ���������� ������������ ���������� ����
     * � �������
     * @return ������������ ���������� ����
     */
    public int getMaxSize() {
        return MAX_SIZE_CLINIC;
    }
}
