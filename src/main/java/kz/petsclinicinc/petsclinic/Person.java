package kz.petsclinicinc.petsclinic;

import kz.petsclinicinc.petsclinic.Pets.Pet;

/**
 * Класс для работы с Персоной
 */
public class Person {

    private String nameOfPerson;
    private Pet petOfPerson;

    public Person(final String nameOfPerson, final Pet petOfPerson) {
        this.nameOfPerson = nameOfPerson;
        this.petOfPerson = petOfPerson;
    }

    /**
     * Для получения имя Персоны
     * @return имя Персоны
     */
    public String getNameOfPerson() {
        return this.nameOfPerson;
    }

    /**
     * Для получения имени животного
     * использует метод getNameOfPet()
     * класса Pet
     * @return имя животного
     */
    public String getNameOfPet() {
        return petOfPerson.getNameOfPet();
    }

    /**
     * Для смены имени Персоны
     * @param newNameOfPerson новое имя Персоны
     */
    public void setName(final String newNameOfPerson) {
        this.nameOfPerson = newNameOfPerson;
    }

    /**
     * Для смены имени животного
     * использует метод setPetName()
     * класса Pet
     * @param newNameOfPet новое имя
     * животного
     */
    public void setPetName(final String newNameOfPet) {
        this.petOfPerson.setPetName(newNameOfPet);
    }

    /**
     * Для получения ссылку на животное
     * @return возвращает ссылку
     * на животное
     */
    public Pet getPet() {
        return this.petOfPerson;
    }

    @Override
    public String toString() {
        return "Person: " + this.nameOfPerson + ", " + petOfPerson.toString();
    }
}
