/*
todo
1) Диалог по занесению данных о кб
    а) сохранение данных в репозиторий
    б) изменение данных
    в) удаление данных
2) Диалог по актуальным данным по моему кб
На 20.05.23 у вас действует кб по следующим предложениям

Карта Альфа-банк (актуально до 25.05.23)
1% на всё
5% Дом и ремонт
5% Спорттовары

Карта Озон (Еком банк) (актуально до 01.06.23)
10% на всё (до 10.06, общий лимит в 500 руб КБ)
1% Спорттовары
1% Рестораны и фастфуд
скидка на покупки через Озон

 */

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    static final Scanner myScan = new Scanner(System.in);
    public static void main(String[] args) throws ParseException, IOException {

        // Fill in test data

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

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

        Repository myRepo = new cbRepository();
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



        CbChance chance1 = new CbChance("тестовый шанс 1", card1, dateFormat.parse("01-07-2023"),
                dateFormat.parse("31-07-2023"), cat1, 0.01);
        CbChance chance2 = new CbChance("тестовый шанс 2", card2, dateFormat.parse("01-01-2012"),
                dateFormat.parse("01-01-2012"), cat2, 0.1);
        CbChance chance3 = new CbChance("тестовый шанс 3", card3, dateFormat.parse("01-01-2012"),
                dateFormat.parse("01-01-2012"), cat3, 0.15);
        CbChance chance4 = new CbChance("тестовый шанс 4", card1, dateFormat.parse("01-01-2012"),
                dateFormat.parse("01-01-2012"), cat4, 0.005);
        CbChance chance5 = new CbChance("тестовый шанс 5", card4, dateFormat.parse("01-01-2012"),
                dateFormat.parse("01-01-2012"), cat5, 0.30);
        CbChance chance6 = new CbChance("тестовый шанс 6", card2, dateFormat.parse("01-01-2012"),
                dateFormat.parse("01-01-2012"), cat5, 0.30);


        Database.addCbProposal(chance1);
        Database.addCbProposal(chance2);
        Database.addCbProposal(chance3);
        Database.addCbProposal(chance4);
        Database.addCbProposal(chance5);
        Database.addCbProposal(chance6);


        Controller.mainMenu();
        myScan.close();
    }


}
