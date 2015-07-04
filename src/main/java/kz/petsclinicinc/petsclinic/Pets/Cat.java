package kz.petsclinicinc.petsclinic.Pets;

/**
 * Кот, наследует Pet
 */
public class Cat extends Pet {
    private static final String CAT_ABILITY = "KILL BIRDS";


    public Cat(final String nameOfPet) {
        super(nameOfPet, CAT_ABILITY, Bird.class);
    }
}
