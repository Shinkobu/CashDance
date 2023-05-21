import Proposals.Card;
import Proposals.CbCategory;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Methods {
    public static void addNewCard() {

        String name;
        String bankName;

        try (Scanner myScan = new Scanner(System.in)) {
            System.out.println("Название банка, например, Сбербанк: \n");
            bankName = myScan.nextLine();

            System.out.println("Название карты, например, Карта сбера: \n");
            name = myScan.nextLine();
        }

        Card newCard = new Card(name, bankName);

        Repository.addNewCard(newCard);
        System.out.println("\nКарта успешно добавлена в базу данных\n");
        System.out.println("База данных имеет вид:\n");
        Database.showCardDB();
    }

    public static void addNewCbProposal() throws IOException {

    /*        public CbProposal(String name, Card card, Date startDate, Date endDate, HashMap< CbCategory, Double> categoryMap, String userComment) {
            this.name = name;
            this.card = card;
            this.startDate = startDate;
            this.endDate = endDate;
            this.categoryMap = categoryMap;
            this.userComment = userComment;

     */

        Date startDate;
        Date endDate;
        HashMap <CbCategory, Double> categoryMap;

        Card card = findCardByName();
//todo
//        try (Scanner myScan = new Scanner(System.in)) {
//            System.out.println("Название, например, акции по сберу Сбербанк: \n");
//            bankName = myScan.nextLine();
//
//            System.out.println("Название карты, например, Карта сбера: \n");
//            name = myScan.nextLine();
        }


//
//        Repository.addNewCard(newCard);
//        System.out.println("\nКарта успешно добавлена в базу данных\n");
//        System.out.println("База данных имеет вид:\n");
//        Database.showCardDB();
    }

    public static Card findCardByName() throws IOException {

        String tempName;
        try(Scanner myScan = new Scanner(System.in)){
            System.out.println("\nБаза данных имеет вид:\n");
            Database.showCardDB();

            System.out.println("Введите название карты\n");
            tempName = myScan.nextLine();
        }

        Card foundCard = Repository.findByName(tempName);

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
