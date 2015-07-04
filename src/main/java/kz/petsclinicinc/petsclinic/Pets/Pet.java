package kz.petsclinicinc.petsclinic.Pets;

/**
 * јбстрактный класс предок
 * дл€ всех животных
 */
public abstract class Pet {

    private String nameOfPet;
    private String pet_ability;

    public Pet(final String nameOfPet, final String pet_ability) {
        this.nameOfPet = nameOfPet;
        this.pet_ability = pet_ability;
    }

    /**
     * ƒл€ получени€ типа животного
     * @return тип животного,
     * например Cat
     */
    public String getPetType() {
        return this.getClass().getSimpleName();
    }

    /**
     * ƒл€ получени€ имени животного
     * @return им€ животного
     */
    public String getNameOfPet() {
        return nameOfPet;
    }

    /**
     * ”станавливает новое им€ животного
     * @param newNameOfPet новое им€ животного
     */
    public void setPetName(String newNameOfPet) {
        this.nameOfPet = newNameOfPet;
    }

    @Override
    public String toString() {
        return "Pet: " + this.getPetType() + ", name is " + this.nameOfPet + ", ability is: " + this.pet_ability;
    }
}
