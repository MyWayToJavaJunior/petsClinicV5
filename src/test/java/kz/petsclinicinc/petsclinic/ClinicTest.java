package kz.petsclinicinc.petsclinic;

import kz.petsclinicinc.petsclinic.Pets.*;
import kz.petsclinicinc.petsclinic.UserException.UserException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тесты для класса Clinic
 */
public class ClinicTest {

    private static final String SECOND_PERSON_NAME = "secondpersonname";
    private static final String FIRST_PERSON_NAME = "firstpersonname";
    private static final String FIRST_PET_NAME = "fristpetname";
    private static final String SECOND_PET_NAME = "secondpetname";
    private static Pet FIRST_PET = new Cat(FIRST_PET_NAME);
    private static Pet SECOND_PET = new Dog(SECOND_PET_NAME);

    /**
     * Тест метода добавления Add()
     * новых персон сравенением
     * ожидаемы данных и полученых после
     * добавления методом Add()
     * @throws Exception несоответсвие данных
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
     * Проверка на выдачу ошибки
     * при добавлении Персоны в
     * клинику где нет мест
     * @throws UserException ошибка
     * добавления персоны в клинику
     * без мест
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
     * Проверка на выдачу ошибки
     * при добавлении Персоны с именем
     * которое уже есть в клинике
     * @throws UserException Пресона
     * с таким именем уже существует
     */
    @Test (expected = UserException.class)
    public void testAddExceptionPersonAlreadyExist() throws UserException {
        Clinic clinic = new Clinic();
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
    }

    /**
     * проверка метода
     * getPersonsCount() возвращающего
     * количество персон в клинике
     * песле добавления одной персоны,
     * а затем и второй
     * @throws Exception количество
     * возврашенное методом getPersonsCount()
     * не соответсвует числу Персон
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
     * В клинику добавляются две
     * персоны, после чего сверяются
     * данные полученные методом getPersonById()
     * по индексу 1 и ожидаемые
     * @throws Exception данные полученные
     * методом getPersonById() не сходятся
     * с ожидаемыми
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
     * Проверяется соответсвие ожидаемого
     * и возвращенного в результате поиска
     * по именни Персоны методом getPersonByName()
     * имени Персоны.
     * @throws Exception при несовпадении ожидаемого
     * и вовзращенного методом getPersonByName()
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
     * Проверяется соответсвие ожидаемого
     * и возвращаемого в результате поиска
     * по именни животного методом getPersonByPetName()
     * имени Персоны.
     * @throws Exception при несовпадении ожидаемого
     * и вовзращенного методом getPersonByPetName()
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
     * Проверяется соответсвие ожидаемого и
     * возвращаемого количества Персон до и после
     * использования метода remove()
     * @throws Exception при несоответсвии
     * ожидаемого и возвращенного значений
     * до и после использования remove()
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
     * Проверяется соответсвие ожидаемого и
     * возвращаемого значений методом isClinicFull()
     * до и после полного заполнения клиники
     * @throws Exception при несоответсвии
     * ожидаемого и возвращенного значений
     * до и после использования isClinicFull()
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
     * Проверяется соответсвие ожидаемого и
     * возвращаемого значений методом isPersonAlreadyExist()
     * до и после добавления в масив элемента
     * с именем подобным исползуемому в параметре
     * метода isPersonAlreadyExist()
     * @throws Exception при несоответсвии
     * ожидаемого и возвращенного значений
     * до и после добавления элемента с
     * с подобным проверяемому именем
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
     * Проверяется соответсвие ожидаемого
     * и вовзращенного имен до
     * и после использования метода renPerson()
     * @throws Exception при несоответсвии ожидаемого
     * и возвращенного имени после использования
     * метода renPerson()
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
     * Проверка на выдачу ошибки
     * при использовании в переименовании
     * имени которое уже используется
     * в клинике
     * @throws UserException Пресона
     * с таким именем уже существует
     */
    @Test(expected = UserException.class)
    public void testRenPersonExceptionPersonAlreadyExist() throws Exception {
        Clinic clinic = new Clinic();
        clinic.add(FIRST_PERSON_NAME, FIRST_PET);
        clinic.add(SECOND_PERSON_NAME, SECOND_PET);
        clinic.renPerson(clinic.getPersonByName(SECOND_PERSON_NAME), FIRST_PERSON_NAME);
    }
}