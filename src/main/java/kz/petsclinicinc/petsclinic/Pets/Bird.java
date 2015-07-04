package kz.petsclinicinc.petsclinic.Pets;

/**
 * ѕтица, наследует Pet
 */
public class Bird extends Pet {
    private static final String BIRD_ABILITY = "KILL DOGS";


    public Bird(final String nameOfPet) {
        super(nameOfPet, BIRD_ABILITY);
    }
}
