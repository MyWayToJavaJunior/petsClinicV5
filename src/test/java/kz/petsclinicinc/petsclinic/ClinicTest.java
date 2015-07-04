package kz.petsclinicinc.petsclinic;

import kz.petsclinicinc.petsclinic.Pets.*;
import kz.petsclinicinc.petsclinic.UserException.UserException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ����� ��� ������ Clinic
 */
public class ClinicTest {

    private static final String SECOND_PERSON_NAME = "secondpersonname";
    private static final String FIRST_PERSON_NAME = "firstpersonname";
    private static final String FIRST_PET_NAME = "fristpetname";
    private static final String SECOND_PET_NAME = "secondpetname";
    private static Pet FIRST_PET = new Cat(FIRST_PET_NAME);
    private static Pet SECOND_PET = new Dog(SECOND_PET_NAME);

    /**
     * ���� ������ ���������� Add()
     * ����� ������ �����������
     * �������� ������ � ��������� �����
     * ���������� ������� Add()
     * @throws Exception ������������� ������
     */
    @Test
    public void testAdd() throws Exception {
        final String expectedPersonName = FIRST_PERSON_NAME;
        final String expectedPetName = FIRST_PET_NAME;
        final Class<? extends Pet> expectedClassPet = FIRST_PET.getClass();
        Clinic clinic = new Clinic();
        clinic.add(FIRST_PERSON_NAME, new Cat(FIRST_PET_NAME));
        final String actualPersonName = clinic.getPersonById(0).getNameOfPerson();
        final String actualPetName = clinic.getPersonById(0).getNameOfPet();
        final Class<? extends Pet> actualClassPet = (clinic.getPersonById(0)).getPet().getClass();
        assertEquals(expectedPersonName, actualPersonName);
        assertEquals(expectedPetName, actualPetName);
        assertEquals(expectedClassPet, actualClassPet);
    }

    /**
     * �������� �� ������ ������
     * ��� ���������� ������� �
     * ������� ��� ��� ����
     * @throws UserException ������
     * ���������� ������� � �������
     * ��� ����
     */
    @Test (expected = UserException.class)
    public void testAddExceptionClinicFull() throws UserException {
        Clinic clinic = new Clinic();
        for (int i = 0; i < clinic.getMaxSize(); i++) {
            clinic.add(FIRST_PERSON_NAME + i, FIRST_PET);
        }
        clinic.add(FIRST_PERSON_NAME + 101, FIRST_PET);
    }

    /**
     * �������� �� ������ ������
     * ��� ���������� ������� � ������
     * ������� ��� ���� � �������
     * @throws UserException �������
     * � ����� ������ ��� ����������
     */
    @Test (expected = UserException.class)
    public void testAddExceptionPersonAlreadyExist() throws UserException {
        Clinic clinic = new Clinic();
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
    }

    /**
     * �������� ������
     * getPersonsCount() �������������
     * ���������� ������ � �������
     * ����� ���������� ����� �������,
     * � ����� � ������
     * @throws Exception ����������
     * ������������ ������� getPersonsCount()
     * �� ������������ ����� ������
     */
    @Test
    public void testGetPersonsCount() throws Exception {
        final int expectedFirstValue = 1;
        final int expectedSecondValue = 2;
        Clinic clinic = new Clinic();
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
        final int actualFirstValue = clinic.getPersonsCount();
        clinic.add(SECOND_PERSON_NAME, FIRST_PET);
        final int actualSecondValue = clinic.getPersonsCount();
        assertEquals(expectedFirstValue, actualFirstValue);
        assertEquals(expectedSecondValue, actualSecondValue);
    }

    /**
     * � ������� ����������� ���
     * �������, ����� ���� ���������
     * ������ ���������� ������� getPersonById()
     * �� ������� 1 � ���������
     * @throws Exception ������ ����������
     * ������� getPersonById() �� ��������
     * � ����������
     */
    @Test
    public void testGetPersonById() throws Exception {
        final String expectedPersonName = SECOND_PERSON_NAME;
        final String expectedPetName = FIRST_PET_NAME;
        final Class<? extends Pet> expectedClassPet = FIRST_PET.getClass();
        Clinic clinic = new Clinic();
        clinic.add(FIRST_PERSON_NAME, new Cat(FIRST_PET_NAME));
        clinic.add(SECOND_PERSON_NAME, new Cat(FIRST_PET_NAME));
        final String actualPersonName = clinic.getPersonById(1).getNameOfPerson();
        final String actualPetName = clinic.getPersonById(1).getNameOfPet();
        final Class<? extends Pet> actualClassPet = (clinic.getPersonById(1)).getPet().getClass();
        assertEquals(expectedPersonName, actualPersonName);
        assertEquals(expectedPetName, actualPetName);
        assertEquals(expectedClassPet, actualClassPet);
    }

    /**
     * ����������� ����������� ����������
     * � ������������� � ���������� ������
     * �� ������ ������� ������� getPersonByName()
     * ����� �������.
     * @throws Exception ��� ������������ ����������
     * � ������������� ������� getPersonByName()
     */
    @Test
    public void testGetPersonByName() throws Exception {
        final String expectedPersonName = SECOND_PERSON_NAME;
        Clinic clinic = new Clinic();
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
        clinic.add(SECOND_PERSON_NAME, FIRST_PET);
        final String actualPersonName =
                clinic.getPersonByName(SECOND_PERSON_NAME).getNameOfPerson();
        assertEquals(expectedPersonName, actualPersonName);
    }

    /**
     * ����������� ����������� ����������
     * � ������������� � ���������� ������
     * �� ������ ��������� ������� getPersonByPetName()
     * ����� �������.
     * @throws Exception ��� ������������ ����������
     * � ������������� ������� getPersonByPetName()
     */
    @Test
    public void testGetPersonByPetName() throws Exception {
        final String expectedPetName = SECOND_PET_NAME;
        Clinic clinic = new Clinic();
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
        clinic.add(SECOND_PERSON_NAME, SECOND_PET);
        final String actualPetName =
                clinic.getPersonByPetName(SECOND_PET_NAME).getNameOfPet();
        assertEquals(expectedPetName, actualPetName);
    }

    /**
     * ����������� ����������� ���������� �
     * ������������� ���������� ������ �� � �����
     * ������������� ������ remove()
     * @throws Exception ��� �������������
     * ���������� � ������������� ��������
     * �� � ����� ������������� remove()
     */
    @Test
    public void testRemove() throws Exception {
        final int expectedCountOfPersonsBeforeRem = 2;
        final int expectedCountOfPersonsAfterRem = 1;
        Clinic clinic = new Clinic();
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
        clinic.add(SECOND_PERSON_NAME, SECOND_PET);
        final int actualCountOfPersonsBeforeRem = clinic.getPersonsCount();
        clinic.remove(clinic.getPersonById(1));
        final int actualCountOfPersonsAfterRem = clinic.getPersonsCount();
        assertEquals(expectedCountOfPersonsBeforeRem, actualCountOfPersonsBeforeRem);
        assertEquals(expectedCountOfPersonsAfterRem, actualCountOfPersonsAfterRem);
    }

    /**
     * ����������� ����������� ���������� �
     * ������������� �������� ������� isClinicFull()
     * �� � ����� ������� ���������� �������
     * @throws Exception ��� �������������
     * ���������� � ������������� ��������
     * �� � ����� ������������� isClinicFull()
     */
    @Test
    public void testIsClinicFull() throws Exception {
        final boolean expectedValueBeforeAdd = false;
        final boolean expectedValueAfterAdd = true;
        Clinic clinic = new Clinic();
        final boolean actualValueBeforeAdd = clinic.isClinicFull();
        for (int i = 0; i < clinic.getMaxSize(); i++) {
            clinic.add(FIRST_PERSON_NAME + i, FIRST_PET);
        }
        final boolean actualValueAfterAdd = clinic.isClinicFull();
        assertEquals(expectedValueBeforeAdd, actualValueBeforeAdd);
        assertEquals(expectedValueAfterAdd, actualValueAfterAdd);
    }

    /**
     * ����������� ����������� ���������� �
     * ������������� �������� ������� isPersonAlreadyExist()
     * �� � ����� ���������� � ����� ��������
     * � ������ �������� ������������ � ���������
     * ������ isPersonAlreadyExist()
     * @throws Exception ��� �������������
     * ���������� � ������������� ��������
     * �� � ����� ���������� �������� �
     * � �������� ������������ ������
     */
    @Test
    public void testIsPersonAlreadyExist() throws Exception {
        final boolean expectedValueBeforeAdd = false;
        final boolean expectedValueAfterAdd = true;
        Clinic clinic = new Clinic();
        final boolean actualValueBeforeAdd = clinic.isPersonAlreadyExist(FIRST_PERSON_NAME);
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
        final boolean actualValueAfterAdd = clinic.isPersonAlreadyExist(FIRST_PERSON_NAME);
        assertEquals(expectedValueBeforeAdd, actualValueBeforeAdd);
        assertEquals(expectedValueAfterAdd, actualValueAfterAdd);
    }

    /**
     * ����������� ����������� ����������
     * � ������������� ���� ��
     * � ����� ������������� ������ renPerson()
     * @throws Exception ��� ������������� ����������
     * � ������������� ����� ����� �������������
     * ������ renPerson()
     */
    @Test
    public void testRenPerson() throws Exception {
        final String expectedPersonName = SECOND_PERSON_NAME;
        Clinic clinic = new Clinic();
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
        clinic.renPerson(clinic.getPersonById(0), SECOND_PERSON_NAME);
        final String actualPersonName = clinic.getPersonById(0).getNameOfPerson();
        assertEquals(expectedPersonName, actualPersonName);
    }

    /**
     * �������� �� ������ ������
     * ��� ������������� � ��������������
     * ����� ������� ��� ������������
     * � �������
     * @throws UserException �������
     * � ����� ������ ��� ����������
     */
    @Test(expected = UserException.class)
    public void testRenPersonExceptionPersonAlreadyExist() throws Exception {
        Clinic clinic = new Clinic();
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
        clinic.add(SECOND_PERSON_NAME, SECOND_PET);
        clinic.renPerson(clinic.getPersonByName(SECOND_PERSON_NAME), FIRST_PERSON_NAME);
    }
}