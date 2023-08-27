package edu.cashdance.SQL;

import edu.cashdance.CashDanceApp;
import edu.cashdance.domain.BankCard;
import edu.cashdance.domain.CbCategory;
import edu.cashdance.domain.CbChance;
import edu.cashdance.domain.ConsoleRepository;
import edu.cashdance.web.BankCardRequest;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static edu.cashdance.CashDanceApp.logger;

public class WebSqlDataGetter {

    private ConnectionBuilder connectionBuilder;

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
}

