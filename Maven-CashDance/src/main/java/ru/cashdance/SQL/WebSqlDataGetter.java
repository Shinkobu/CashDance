package ru.cashdance.SQL;

import ru.cashdance.domain.BankCard;
import ru.cashdance.web.BankCardRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.cashdance.CashDanceApp.logger;

public class WebSqlDataGetter {

    private ru.cashdance.SQL.ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }

    public BankCard findBandCard(BankCardRequest request) {

        BankCard bankCard1 = new BankCard();

        int i = request.getIndex();

        try (Connection connection = connectionBuilder.getConnection()) {

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM cards WHERE id_card = " + i + "");
            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1) + " : " +
//                        resultSet.getString(2) + " : " +
//                        resultSet.getString(3));

                bankCard1.setBankName(resultSet.getString(3));
                bankCard1.setName(resultSet.getString(2));
                bankCard1.setIndexInDb(Integer.parseInt(resultSet.getString(1)));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage() + " this is error");
            throw new RuntimeException(e);
        }

        return bankCard1;
    }

    public ArrayList<BankCard> allBankCards() {

        ArrayList<BankCard> resultList = new ArrayList<>();;
        try (Connection connection = connectionBuilder.getConnection()) {

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM cards");
            while (resultSet.next()) {
                BankCard tempBC = new BankCard();
                tempBC.setBankName(resultSet.getString(3));
                tempBC.setName(resultSet.getString(2));
                tempBC.setIndexInDb(Integer.parseInt(resultSet.getString(1)));
                resultList.add(tempBC);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage() + " this is error");
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public static void main(String[] args) {

        WebSqlDataGetter webSqlDataGetter = new WebSqlDataGetter();
        BankCardRequest bankCardRequest = new BankCardRequest();
        bankCardRequest.setIndex(1);
        webSqlDataGetter.findBandCard(bankCardRequest);
    }
}

