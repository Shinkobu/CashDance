package domain;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Methods {
    public static Card createNewCard() {

        String name;
        String bankName;

        System.out.println("Название банка, например, Сбербанк: \n");
        bankName = App.myScan.nextLine();

        System.out.println("Название карты, например, Карта сбера: \n");
        name = App.myScan.nextLine();

        Card newCard = new Card(name, bankName);
        return newCard;
    }

    public static CbCategory createNewCategory() {


        String name;

        System.out.println("Введите название категории: \n");
        name = App.myScan.nextLine();

        CbCategory category = new CbCategory(name);

        return category;
    }

    public static void addNewCbProposal() throws IOException {

        /*
        1) Ввести новые категории кешбека по карте?
        2) Выбери карту
        3) С какой даты действует?
        4) До какой даты действует?
        5) Вот категории, выбери категорию
        6) Хорошо, укажи % кешбека
        7) Ещё категории? Если да, то 5,6,7...
        8) Новые категории сохранены. БД имеет вид
         */

        String name;
        Card card;
        Date startDate;
        Date endDate;
        HashMap<CbCategory, Double> categoryMap;
        String userComment;


//        Date startDate;
//        Date endDate;
//        HashMap <CashDance.domain.CbCategory, Double> categoryMap;

//        CashDance.domain.Card card = findCardByName();


//            System.out.println("Название, например, акции по сберу Сбербанк: \n");
//            bankName = myScan.nextLine();

//            System.out.println("Название карты, например, Карта сбера: \n");
//            name = myScan.nextLine();
    }


    public static Card findCardByName() throws IOException {

        String tempName;
        try (Scanner myScan = new Scanner(System.in)) {
            System.out.println("\nБаза данных имеет вид:\n");
            Database.showCardDB();

            System.out.println("Введите название карты\n");
            tempName = myScan.nextLine();
        }

        Card foundCard = SqlDataGetter.findByName(tempName);

        if (foundCard != null) {
            System.out.println("\nКарта " + tempName + " найдена!");
            System.out.println(foundCard.toString());
            int index = foundCard.getIndexInDb();

        } else {
            System.out.println("\nКарта " + tempName + " не найдена!");
        }
        return foundCard;
    }

}
