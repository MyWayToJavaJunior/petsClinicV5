package kz.petsclinicinc.petsclinic.Pets;

/**
 * Собака, наследует Pet
 */
public class Dog extends Pet {
    private static final String DOG_ABILITY = "KILL CATS";


    public Dog(final String nameOfPet) {
        super(nameOfPet, DOG_ABILITY);
    }
}
