package ru.cashdance.domain;

import ru.cashdance.CashDanceApp;
import ru.cashdance.SQL.ConsoleSqlDataGetter;
import ru.cashdance.old.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Methods {

    private static final Logger logger = LogManager.getLogger(Methods.class.getName());

    public static BankCard createNewCard() {

        String name;
        String bankName;

        System.out.println("Название банка, например, Сбербанк: \n");
        bankName = CashDanceApp.myScan.nextLine();

        System.out.println("Название карты, например, Карта сбера: \n");
        name = CashDanceApp.myScan.nextLine();

        BankCard newBankCard = new BankCard(name, bankName);
        return newBankCard;
    }

    public static CbCategory createNewCategory() {

        String name;
        System.out.println("Введите название категории: \n");
        name = CashDanceApp.myScan.nextLine();
        CbCategory category = new CbCategory(name);
        return category;
    }

    public static CbChance CbChanceBuilder() {

        logger.info("Started creating a new CbChance");
        logger.debug("Started creating a new CbChance - debug test");

        String name;
        int cardID;
        LocalDate startDate;
        LocalDate endDate;
        int categoryID;
        Double rate;

        String temp;

        ConsoleSqlDataGetter consoleSqlDataGetter = new ConsoleSqlDataGetter();

        try {

            // TODO: 29.07.2023 Add while !hasnext...
            System.out.println("Введите название кэшбек шанса: \n");
            name = CashDanceApp.myScan.nextLine();

            System.out.println("Выберите банковскую карту: \n");
            cardID = consoleSqlDataGetter.findCard();

            System.out.println("Выберите категорию: \n");
            categoryID = consoleSqlDataGetter.findCategory();

            System.out.println("Введите дату начала действия кэшбека в формате dd-mm-yyyy: \n");
            temp = CashDanceApp.myScan.nextLine();
            startDate = LocalDate.parse(temp,CashDanceApp.oldDateFormatter);

            System.out.println("Введите дату окончания действия кэшбека в формате dd-mm-yyyy: \n");
            temp = CashDanceApp.myScan.nextLine();
            endDate = LocalDate.parse(temp,CashDanceApp.oldDateFormatter);

            System.out.println("Введите % ставку кэшбека: \n");
            rate = Double.valueOf(CashDanceApp.myScan.nextLine());


        } catch (DateTimeParseException e) {
            logger.info(e.getMessage() + e + " this is info");
            logger.debug("{}", () -> e + "this is debug");
            logger.error(e.getMessage() + e + " this is error");
            throw new RuntimeException(e);
        }

        CbChance cbChance = new CbChance(name, cardID, startDate, endDate, categoryID, rate);
        logger.info("Finished creating a new CbChance");
        return cbChance;
    }


    public static BankCard findCardByName() {

        String tempName;
        try (Scanner myScan = new Scanner(System.in)) {
            System.out.println("\nБаза данных имеет вид:\n");
            Database.showCardDB();

            System.out.println("Введите название карты\n");
            tempName = myScan.nextLine();
        }

        ConsoleSqlDataGetter consoleSqlDataGetter = new ConsoleSqlDataGetter();

        BankCard foundBankCard = consoleSqlDataGetter.findByName(tempName);

        if (foundBankCard != null) {
            System.out.println("\nКарта " + tempName + " найдена!");
            System.out.println(foundBankCard.toString());
            int index = foundBankCard.getIndexInDb();

        } else {
            System.out.println("\nКарта " + tempName + " не найдена!");
        }
        return foundBankCard;
    }

}
