package kz.petsclinicinc.petsclinic;

import kz.petsclinicinc.petsclinic.controller.ClinicController;

/**
 * �������� �����, �����������������
 * ���������
 */
public class Main {
    public static void main(String[] args) {
        ClinicController clinicController =
                new ClinicController();
        clinicController.doWork();
    }
}
