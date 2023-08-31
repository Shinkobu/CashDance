package ru.cashdance.old;

import ru.cashdance.CashDanceApp;
import ru.cashdance.domain.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

        BankCard bankCard1 = new BankCard("Карта Сбера", "Сбербанк");
        BankCard bankCard2 = new BankCard("Карта Альфы", "Альфа-банк");
        BankCard bankCard3 = new BankCard("Карта Тинькофф", "Тинькофф");
        BankCard bankCard4 = new BankCard("Карта Сбера вирт", "Сбербанк");

        ConsoleRepository myRepo = new CbConsoleRepository();
        myRepo.addNewCard(bankCard1);
        myRepo.addNewCard(bankCard2);
        myRepo.addNewCard(bankCard3);
        myRepo.addNewCard(bankCard4);

        myRepo.addNewCategory(cat1);
        myRepo.addNewCategory(cat2);
        myRepo.addNewCategory(cat3);
        myRepo.addNewCategory(cat4);
        myRepo.addNewCategory(cat5);
        myRepo.addNewCategory(cat6);

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String text = date.format(formatter);
        LocalDate parsedDate = LocalDate.parse("01-07-2023", CashDanceApp.oldDateFormatter);

        CbChance chance1 = new CbChance("тестовый шанс 1", bankCard1, LocalDate.parse("01-07-2023", CashDanceApp.oldDateFormatter),
                LocalDate.parse("31-07-2023", CashDanceApp.oldDateFormatter), cat1, 0.01);
        CbChance chance2 = new CbChance("тестовый шанс 2", bankCard2, LocalDate.parse("01-01-2012", CashDanceApp.oldDateFormatter),
                LocalDate.parse("01-01-2012", CashDanceApp.oldDateFormatter), cat2, 0.1);
        CbChance chance3 = new CbChance("тестовый шанс 3", bankCard3, LocalDate.parse("01-01-2012", CashDanceApp.oldDateFormatter),
                LocalDate.parse("01-01-2012", CashDanceApp.oldDateFormatter), cat3, 0.15);
        CbChance chance4 = new CbChance("тестовый шанс 4", bankCard1, LocalDate.parse("01-01-2012", CashDanceApp.oldDateFormatter),
                LocalDate.parse("01-01-2012", CashDanceApp.oldDateFormatter), cat4, 0.005);
        CbChance chance5 = new CbChance("тестовый шанс 5", bankCard4, LocalDate.parse("01-01-2012", CashDanceApp.oldDateFormatter),
                LocalDate.parse("01-01-2012", CashDanceApp.oldDateFormatter), cat5, 0.30);
        CbChance chance6 = new CbChance("тестовый шанс 6", bankCard2, LocalDate.parse("01-01-2012", CashDanceApp.oldDateFormatter),
                LocalDate.parse("01-01-2012", CashDanceApp.oldDateFormatter), cat5, 0.30);


        Database.addCbProposal(chance1);
        Database.addCbProposal(chance2);
        Database.addCbProposal(chance3);
        Database.addCbProposal(chance4);
        Database.addCbProposal(chance5);
        Database.addCbProposal(chance6);
    }

}
