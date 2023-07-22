package domain;/*
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
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static final Scanner myScan = new Scanner(System.in);
    static SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
    static SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException, SQLException {

        // Fill in test data
        //CashDance.domain.TestData.loadTestData();


        Controller.mainMenu();
        myScan.close();
    }


}
