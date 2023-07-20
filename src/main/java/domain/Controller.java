package domain;

import SQL.SqlDataGetter;

public class Controller {
    static SqlDataGetter sqlDataGetter = new SqlDataGetter();

    public static void mainMenu() {



        System.out.println("\nВыберите действие\n");
        System.out.println("" +
                "1 - Мои банковские карты\n" +
                "2 - Мои категории кешбека\n" +
                "3 - Мой кэшбек\n" +
                "9 - Завершить работу \n");

        int choice = 0;
        try {
            choice = Integer.parseInt(App.myScan.nextLine());
        } catch (NumberFormatException exception) {
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
                System.out.println("Категории вашего кэшбека: ");
                sqlDataGetter.showCbChances();
                mainMenu();
                break;
            case 9:
                System.exit(1);
                break;
        }
    }

    public static void cardMenu() {


        sqlDataGetter.showMyCards();

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
            choice = Integer.parseInt(App.myScan.nextLine());
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }
        int indexDB;
        Card tempCard;

        switch (choice) {

            case 22:

                tempCard = Methods.createNewCard(); // создаёт в диалоге новую карту
                sqlDataGetter.addNewCard(tempCard);// записывает карту через репо в БД
                System.out.println("\nКарта успешно добавлена в базу данных\n");
                System.out.println("База данных имеет вид:\n");

                cardMenu();
                break;
            case 33:
                indexDB = sqlDataGetter.findCard();  // поиск карты для замены
                tempCard = Methods.createNewCard(); // создаёт в диалоге новую карту
                sqlDataGetter.changeCard(indexDB,tempCard); // замена старой карты на новую
                cardMenu();
                break;
            case 44:
                indexDB = sqlDataGetter.findCard();  // поиск карты для удаления
                sqlDataGetter.deleteCard(indexDB); // удаление карты из БД
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

        SqlDataGetter sqlDataGetter = new SqlDataGetter();
        sqlDataGetter.showMyCategories();

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
            choice = Integer.parseInt(App.myScan.nextLine());
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }
        int indexDB;
        CbCategory tempCategory;

        switch (choice) {

            case 22:

                tempCategory = Methods.createNewCategory(); // создаёт в диалоге новую категорию
                sqlDataGetter.addNewCategory(tempCategory);// записывает категорию через репо в БД
                categoryMenu();
                break;
            case 33:
                indexDB = sqlDataGetter.findCategory();  // поиск категории для замены
                tempCategory = Methods.createNewCategory(); // создаёт в диалоге новую категорию
                sqlDataGetter.changeCategory(indexDB,tempCategory); // замена старой категории на новую
                categoryMenu();
                break;
            case 44:
                indexDB = sqlDataGetter.findCategory(); // поиск категории для удаления
                sqlDataGetter.deleteCategory(indexDB); // удаление категории из БД
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
}
