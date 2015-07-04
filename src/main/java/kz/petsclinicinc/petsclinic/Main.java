package kz.petsclinicinc.petsclinic;

import kz.petsclinicinc.petsclinic.controller.ClinicController;

/**
 * Основной класс, инициализуирующий
 * конроллер
 */
public class Main {
    public static void main(String[] args) {
        ClinicController clinicController =
                new ClinicController();
        clinicController.doWork();
    }
}
