package kz.petsclinicinc.petsclinic.Pets;

/**
 * �����, ��������� Pet
 */
public class Bird extends Pet {
    private static final String BIRD_ABILITY = "KILL DOGS";


    public Bird(final String nameOfPet) {
        super(nameOfPet, BIRD_ABILITY);
    }
}
