package kz.petsclinicinc.petsclinic.Pets;

/**
 * ����������� ����� ������
 * ��� ���� ��������
 */
public abstract class Pet {

    private String nameOfPet;
    private String pet_ability;

    public Pet(final String nameOfPet, final String pet_ability) {
        this.nameOfPet = nameOfPet;
        this.pet_ability = pet_ability;
    }

    /**
     * ��� ��������� ���� ���������
     * @return ��� ���������,
     * �������� Cat
     */
    public String getPetType() {
        return this.getClass().getSimpleName();
    }

    /**
     * ��� ��������� ����� ���������
     * @return ��� ���������
     */
    public String getNameOfPet() {
        return nameOfPet;
    }

    /**
     * ������������� ����� ��� ���������
     * @param newNameOfPet ����� ��� ���������
     */
    public void setPetName(String newNameOfPet) {
        this.nameOfPet = newNameOfPet;
    }

    @Override
    public String toString() {
        return "Pet: " + this.getPetType() + ", name is " + this.nameOfPet + ", ability is: " + this.pet_ability;
    }
}
