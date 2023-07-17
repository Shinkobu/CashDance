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

import Proposals.*;

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

        CbCategory cat1 = new CbCategory("Pharmacy", "Аптеки");
        CbCategory cat2 = new CbCategory("GasStation", "АЗС");
        CbCategory cat3 = new CbCategory("Tourism", "Путешествия");
        CbCategory cat4 = new CbCategory("Markets", "Продукты");
        CbCategory cat5 = new CbCategory("Appliances", "Бытовая техника");
        CbCategory cat6 = new CbCategory("ALL", "На всё");

        Card card1 = new Card("Карта Сбера", "Сбербанк");
        Card card2 = new Card("Карта Альфы", "Альфа-банк");
        Card card3 = new Card("Карта Тинькофф", "Тинькофф");
        Card card4 = new Card("Карта Сбера вирт", "Сбербанк");

        Repository.addNewCard(card1);
        Repository.addNewCard(card2);
        Repository.addNewCard(card3);
        Repository.addNewCard(card4);

        Map<CbCategory, Double> hashMap1 = new HashMap<>();
        hashMap1.put(cat1, 0.01);
        hashMap1.put(cat2, 0.05);
        hashMap1.put(cat3, 0.07);

        Map <CbCategory, Double> hashMap2 = new HashMap<>();
        hashMap2.put(cat3, 0.15);
        hashMap2.put(cat4, 0.01);
        hashMap2.put(cat5, 0.04);


        CbProposal proposal1 = new CbProposal(card1, dateFormat.parse("01-01-2012"),
                dateFormat.parse("01-01-2012"), hashMap1, "тестовая позиция 1");

        CbProposal proposal2 = new CbProposal(card2, dateFormat.parse("01-01-2012"),
                dateFormat.parse("01-01-2012"), hashMap2, "тестовая позиция 2");

        Database.addCbProposal(proposal1);
        Database.addCbProposal(proposal2);
//        Database.showDB();

        Controller.run();
        myScan.close();
    }


}
