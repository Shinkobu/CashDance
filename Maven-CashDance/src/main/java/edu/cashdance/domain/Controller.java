package edu.cashdance.domain;

import edu.cashdance.CashDanceApp;
import edu.cashdance.SQL.ConsoleSqlDataGetter;

import static edu.cashdance.CashDanceApp.logger;

public class Controller {
    static ConsoleSqlDataGetter consoleSqlDataGetter = new ConsoleSqlDataGetter();

    public static void mainMenu() {



        System.out.println("\nВыберите действие\n");
        System.out.println("" +
                "1 - Мои банковские карты\n" +
                "2 - Мои категории кешбека\n" +
                "3 - Мой кэшбек\n" +
                "9 - Завершить работу \n");

        int choice = 0;
        try {
            choice = Integer.parseInt(CashDanceApp.myScan.nextLine());
        } catch (NumberFormatException exception) {
            logger.error(exception.getMessage() + " this is error");
            exception.printStackTrace();
        }

        switch (choice) {
            case 1:
                cardMenu();
                break;
            case 2:
                categoryMenu();
                break;
            case 3:
                CbMenu();
                break;
            case 9:
                System.exit(1);
                break;
        }
    }

    public static void cardMenu() {
        consoleSqlDataGetter.showMyCards();
        System.out.println("\nВыберите действие\n");
        System.out.println("" +
                "22 - Добавить банковскую карту\n" +
                "33 - Изменить банковскую карту\n" +
                "44 - Удалить банковскую карту\n" +
                "99 - Назад\n" +
                "9 - Завершить работу \n");

        int choice = 0;
        // todo make better parseInt
        try {
            choice = Integer.parseInt(CashDanceApp.myScan.nextLine());
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }
        int indexDB;
        BankCard tempBankCard;

        switch (choice) {

            case 22:

                tempBankCard = Methods.createNewCard(); // создаёт в диалоге новую карту
                consoleSqlDataGetter.addNewCard(tempBankCard);// записывает карту через репо в БД
                System.out.println("\nКарта успешно добавлена в базу данных\n");
                System.out.println("База данных имеет вид:\n");

                cardMenu();
                break;
            case 33:
                indexDB = consoleSqlDataGetter.findCard();  // поиск карты для замены
                tempBankCard = Methods.createNewCard(); // создаёт в диалоге новую карту
                consoleSqlDataGetter.changeCard(indexDB, tempBankCard); // замена старой карты на новую
                cardMenu();
                break;
            case 44:
                indexDB = consoleSqlDataGetter.findCard();  // поиск карты для удаления
                consoleSqlDataGetter.deleteCard(indexDB); // удаление карты из БД
                cardMenu();
                break;
            case 99:
                mainMenu();
                break;
            case 9:
                System.exit(1);
                break;

        }
    }

    public static void categoryMenu() {

        consoleSqlDataGetter.showMyCategories();

        System.out.println("\nВыберите действие\n");
        System.out.println("" +
                "22 - Добавить категорию\n" +
                "33 - Изменить категорию\n" +
                "44 - Удалить категорию\n" +
                "99 - Назад\n" +
                "9 - Завершить работу \n");

        int choice = 0;
        // todo make better parseInt
        try {
            choice = Integer.parseInt(CashDanceApp.myScan.nextLine());
        } catch (NumberFormatException exception) {
            logger.error(exception.getMessage() + " this is error");
            exception.printStackTrace();
        }
        int indexDB;
        CbCategory tempCategory;

        switch (choice) {

            case 22:

                tempCategory = Methods.createNewCategory(); // создаёт в диалоге новую категорию
                consoleSqlDataGetter.addNewCategory(tempCategory);// записывает категорию через репо в БД
                categoryMenu();
                break;
            case 33:
                indexDB = consoleSqlDataGetter.findCategory();  // поиск категории для замены
                tempCategory = Methods.createNewCategory(); // создаёт в диалоге новую категорию
                consoleSqlDataGetter.changeCategory(indexDB,tempCategory); // замена старой категории на новую
                categoryMenu();
                break;
            case 44:
                indexDB = consoleSqlDataGetter.findCategory(); // поиск категории для удаления
                consoleSqlDataGetter.deleteCategory(indexDB); // удаление категории из БД
                categoryMenu();
                break;
            case 99:
                mainMenu();
                break;
            case 9:
                System.exit(1);
                break;

        }
    }
    public static void CbMenu() {
        consoleSqlDataGetter.showCbChances();
        System.out.println("\nВыберите действие\n");
        System.out.println("" +
                "22 - Добавить кэшбек шанс\n" +
                "33 - Изменить кэшбек шанс\n" +
                "44 - Удалить кэшбек шанс\n" +
                "99 - Назад\n" +
                "9 - Завершить работу \n");

        int choice = 0;
        // todo make better parseInt
        try {
            choice = Integer.parseInt(CashDanceApp.myScan.nextLine());
        } catch (NumberFormatException exception) {
            logger.error(exception.getMessage() + " this is error");
            exception.printStackTrace();
        }
        int indexDB;
        CbChance cbChance;

        switch (choice) {

            case 22:
                cbChance = Methods.CbChanceBuilder();
                consoleSqlDataGetter.addNewCbChance(cbChance);
                System.out.println("\nКэшбек успешно добавлен в базу данных\n");
                System.out.println("База данных имеет вид:\n");

                CbMenu();
                break;
            case 33:
                indexDB = consoleSqlDataGetter.findCbChance();
                CbChance tempCbChance = Methods.CbChanceBuilder();
                consoleSqlDataGetter.changeCbChance(indexDB,tempCbChance);
                CbMenu();
                break;
            case 44:
                indexDB = consoleSqlDataGetter.findCbChance();
                consoleSqlDataGetter.deleteCbChance(indexDB);
                CbMenu();
                break;
            case 99:
                mainMenu();
                break;
            case 9:
                System.exit(1);
                break;

        }
    }
}
