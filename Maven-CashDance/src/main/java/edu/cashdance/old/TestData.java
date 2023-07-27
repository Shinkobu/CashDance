package edu.cashdance.old;

import edu.cashdance.App;
import edu.cashdance.domain.*;
import edu.cashdance.old.Database;

import java.text.ParseException;

public class TestData {
    /**
     * Loads test data to database (not sql)
     * @throws ParseException
     */
    public static void loadTestData() throws ParseException {

        CbCategory cat1 = new CbCategory("Аптеки");
        CbCategory cat2 = new CbCategory("АЗС");
        CbCategory cat3 = new CbCategory("Путешествия");
        CbCategory cat4 = new CbCategory("Продукты");
        CbCategory cat5 = new CbCategory("Бытовая техника");
        CbCategory cat6 = new CbCategory("На всё");

        Card card1 = new Card("Карта Сбера", "Сбербанк");
        Card card2 = new Card("Карта Альфы", "Альфа-банк");
        Card card3 = new Card("Карта Тинькофф", "Тинькофф");
        Card card4 = new Card("Карта Сбера вирт", "Сбербанк");

        Repository myRepo = new CbRepository();
        myRepo.addNewCard(card1);
        myRepo.addNewCard(card2);
        myRepo.addNewCard(card3);
        myRepo.addNewCard(card4);

        myRepo.addNewCategory(cat1);
        myRepo.addNewCategory(cat2);
        myRepo.addNewCategory(cat3);
        myRepo.addNewCategory(cat4);
        myRepo.addNewCategory(cat5);
        myRepo.addNewCategory(cat6);



        CbChance chance1 = new CbChance("тестовый шанс 1", card1, App.oldDateFormat.parse("01-07-2023"),
                App.oldDateFormat.parse("31-07-2023"), cat1, 0.01);
        CbChance chance2 = new CbChance("тестовый шанс 2", card2, App.oldDateFormat.parse("01-01-2012"),
                App.oldDateFormat.parse("01-01-2012"), cat2, 0.1);
        CbChance chance3 = new CbChance("тестовый шанс 3", card3, App.oldDateFormat.parse("01-01-2012"),
                App.oldDateFormat.parse("01-01-2012"), cat3, 0.15);
        CbChance chance4 = new CbChance("тестовый шанс 4", card1, App.oldDateFormat.parse("01-01-2012"),
                App.oldDateFormat.parse("01-01-2012"), cat4, 0.005);
        CbChance chance5 = new CbChance("тестовый шанс 5", card4, App.oldDateFormat.parse("01-01-2012"),
                App.oldDateFormat.parse("01-01-2012"), cat5, 0.30);
        CbChance chance6 = new CbChance("тестовый шанс 6", card2, App.oldDateFormat.parse("01-01-2012"),
                App.oldDateFormat.parse("01-01-2012"), cat5, 0.30);


        Database.addCbProposal(chance1);
        Database.addCbProposal(chance2);
        Database.addCbProposal(chance3);
        Database.addCbProposal(chance4);
        Database.addCbProposal(chance5);
        Database.addCbProposal(chance6);
    }

}
