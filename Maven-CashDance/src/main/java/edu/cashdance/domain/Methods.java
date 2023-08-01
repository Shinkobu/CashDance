package edu.cashdance.domain;

import edu.cashdance.SQL.SqlDataGetter;
import edu.cashdance.App;
import edu.cashdance.old.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import static edu.cashdance.App.logger;


public class Methods {

//    private static final Logger logger = LogManager.getLogger(Methods.class.getName());

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

    public static CbChance CbChanceBuilder() {

        logger.info("Started creating a new CbChance");
        logger.debug("Started creating a new CbChance - debug test");

        String name;
        int cardID;
        Date startDate;
        Date endDate;
        int categoryID;
        Double rate;

        String temp;

        SqlDataGetter sqlDataGetter = new SqlDataGetter();

        try {

            // TODO: 29.07.2023 Add while !hasnext...
            System.out.println("Введите название кэшбек шанса: \n");
            name = App.myScan.nextLine();

            System.out.println("Выберите банковскую карту: \n");
            cardID = sqlDataGetter.findCard();

            System.out.println("Выберите категорию: \n");
            categoryID = sqlDataGetter.findCategory();

            System.out.println("Введите дату начала действия кэшбека в формате dd-mm-yyyy: \n");
            temp = App.myScan.nextLine();
            startDate = App.oldDateFormat.parse(temp);

            System.out.println("Введите дату окончания действия кэшбека в формате dd-mm-yyyy: \n");
            temp = App.myScan.nextLine();
            endDate = App.oldDateFormat.parse(temp);

            System.out.println("Введите % ставку кэшбека: \n");
            rate = Double.valueOf(App.myScan.nextLine());


        } catch (ParseException e) {
            logger.info(e.getMessage() + e + " this is info");
            logger.debug("{}", () -> e + "this is debug");
            logger.error(e.getMessage() + e + " this is error");
            throw new RuntimeException(e);
        }

        CbChance cbChance = new CbChance(name, cardID, startDate, endDate, categoryID, rate);
        logger.info("Finished creating a new CbChance");
        return cbChance;
    }


    public static Card findCardByName() {

        String tempName;
        try (Scanner myScan = new Scanner(System.in)) {
            System.out.println("\nБаза данных имеет вид:\n");
            Database.showCardDB();

            System.out.println("Введите название карты\n");
            tempName = myScan.nextLine();
        }

        SqlDataGetter sqlDataGetter = new SqlDataGetter();

        Card foundCard = sqlDataGetter.findByName(tempName);

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
