import Proposals.Card;

import java.io.IOException;
import java.util.Scanner;

public class Controller {

    public static void run() throws IOException {
        int choice = mainMenu();
        switch (choice) {
            case 1:
                System.out.println("Категории вашего кэшбека: ");
                Database.showCbProposalDB();
                break;
            case 11:
                System.out.println("Ваши банковские карты: ");
                Database.showCardDB();
                break;
            case 2:
                Methods.addNewCbProposal();
                break;
            case 3:
//todo
                break;
            case 4:
//todo
                break;
            case 22:
                Methods.addNewCard();
                break;
            case 33:
//todo
                break;
            case 44:
//todo
                break;
        }
        if (choice != 9) {
            run();
        } else {
            System.exit(1);
        }
    }

    public static int mainMenu() {

        System.out.println("\nВыберите действие\n");
        System.out.println("" +
                "1 - todo Мой кэшбек\n" +
                "1 - Мои банковские карты\n" +
                "1 - Вывести категории моего кешбека\n" +
                "11 - Вывести мои карты\n" +
                "2 - Добавить категорию кешбека по карте\n" +
                "3 - Изменить категорию кешбека по карте\n" +
                "4 - Удалить категорию кешбека по карте\n" +
                "22 - Добавить банковскую карту\n" +
                "33 - Изменить банковскую карту\n" +
                "44 - Удалить банковскую карту\n" +
                "9 - Завершить работу \n");

        int choice = 0;
        try {
            choice = Integer.parseInt(App.myScan.nextLine());
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }

        return choice;
    }

    public static int cardMenu() {

        System.out.println("\nВыберите действие\n");
        System.out.println("" +
                "1 - todo Мой кэшбек\n" +
                "1 - Мои банковские карты\n" +
                "1 - Вывести категории моего кешбека\n" +
                "11 - Вывести мои карты\n" +
                "2 - Добавить категорию кешбека по карте\n" +
                "3 - Изменить категорию кешбека по карте\n" +
                "4 - Удалить категорию кешбека по карте\n" +
                "22 - Добавить банковскую карту\n" +
                "33 - Изменить банковскую карту\n" +
                "44 - Удалить банковскую карту\n" +
                "9 - Завершить работу \n");

        int choice = 0;
        try {
            choice = Integer.parseInt(App.myScan.nextLine());
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }

        return choice;
    }
}
