package kz.petsclinicinc.petsclinic;

import kz.petsclinicinc.petsclinic.Pets.Pet;
import kz.petsclinicinc.petsclinic.UserException.UserException;

import java.util.ArrayList;

/**
 * Класс для работы над массивом(коллекцией)
 * Персон
 */
public class Clinic {

    private static final int MAX_SIZE_CLINIC = 100;

    private ArrayList<Person> persons =
            new ArrayList<Person>(MAX_SIZE_CLINIC);


    public void add(final String nameForPerson, Pet pet) throws UserException {
        if (isClinicFull()) {
            throw new UserException("Clinic full, rem unnecessary persons");
        }
        if (isPersonAlreadyExist(nameForPerson)) {
            throw new UserException("Person Already exist");
        }
        persons.add(new Person(nameForPerson, pet));
    }

    public int getPersonsCount() {
        return this.persons.size();
    }

    public Person getPersonById(int idOfPerson) {
        return persons.get(idOfPerson);
    }

    public Person getPersonByName(final String nameOfPersonForFind) {
        Person resultPerson = null;
        for (Person person : persons)
            if (nameOfPersonForFind.equals(person.getNameOfPerson()))
                resultPerson = person;
        return resultPerson;
    }

    public Person getPersonByPetName(String nameOfPetForFind) {
        Person resultPerson = null;
        for (Person person : persons)
            if (nameOfPetForFind.equals(person.getNameOfPet()))
                resultPerson = person;
        return resultPerson;
    }

    public void remove(Person personForRemove) {
        this.persons.remove(personForRemove);
    }

    public boolean isClinicFull() {
        return this.getPersonsCount() == MAX_SIZE_CLINIC;
    }

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

    public int getMaxSize() {
        return MAX_SIZE_CLINIC;
    }
}
