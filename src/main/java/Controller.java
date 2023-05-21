import java.io.IOException;
import java.util.Scanner;

public class Controller {

    public static void run() throws IOException {
        int choice = mainMenu();
        switch (choice) {
            case 1:
                System.out.println("\nБаза данных имеет вид:\n");
                Database.showCbProposalDB();
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
        }else {
            System.exit(1);
        }
    }

    public static int mainMenu() {

        System.out.println("\nВыберите действие\n");
        Scanner myScan = new Scanner(System.in);
        System.out.println("Введите желаемую операцию:\n" +
                "1 - Вывести категории моего кешбека\n" +
                "2 - Добавить категорию кешбека по карте\n" +
                "3 - Изменить категорию кешбека по карте\n" +
                "4 - Удалить категорию кешбека по карте\n" +
                "22 - Добавить банковскую карту\n" +
                "33 - Изменить банковскую карту\n" +
                "44 - Удалить банковскую карту\n" +
                "9 - Завершить работу \n");

        int choice = 0;
        try {
            choice = Integer.parseInt(myScan.nextLine());
        }catch (NumberFormatException exception){
            exception.printStackTrace();
        }

        return choice;
    }
}
