package kz.petsclinicinc.petsclinic.io;

import java.util.Scanner;

/**
 * Класс ввода - вывода
 */
public class IO {

    private static final String MSG_MAIN_MENU = "1 view / 2 add / 3 view by Person /" +
            " 4 view by Pet / 5 rem by Person / 6 rem by Pet /" +
            " 7 ren Person / 8 ren Pet / 9 do Pet action / 0 Exit";
    private static final String ASK_FOR_NAME_PERSON = "Pls input name of Person";
    private static final String ASK_FOR_NAME_PET = "Pls input name of Pet";
    private static final String ASK_FOR_TYPE_PET = "Pls input type of pet: 1 Cat / 2 Bird / 3 Dog";
    private static final String MSG_NOT_FOUND = "Not Found!";
    private static final String ASK_FOR_NEW_NAME_PERSON = "Pls input NEW name of Person";
    private static final String ASK_FOR_NEW_NAME_PET = "Pls input NEW name of Pet";
    private static final String MSG_NOT_A_NUMBER_INITIATED_BY_DEFAULT = "Not a number, initiated by default";

    public static void print(final String stringToPrint) {
        System.out.println(stringToPrint);
    }

    public static void showMainMenu() {
        print(MSG_MAIN_MENU);
    }

    public static void askForNamePerson() {
        print(ASK_FOR_NAME_PERSON);
    }

    public static void askForNamePet() {
        print(ASK_FOR_NAME_PET);
    }

    public static void askForTypePet() {
        print(ASK_FOR_TYPE_PET);
    }

    public static void NotFound() {
        print(MSG_NOT_FOUND);
    }

    public static void askForNewNamePerson() {
        print(ASK_FOR_NEW_NAME_PERSON);
    }

    public static void askForNewNamePet() {
        print(ASK_FOR_NEW_NAME_PET);
    }

    public static void nanInitiatedByDefault() {
        print(MSG_NOT_A_NUMBER_INITIATED_BY_DEFAULT);
    }

    public static void showMsgError(final String errorMsg) {
        print(errorMsg);
    }

    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
