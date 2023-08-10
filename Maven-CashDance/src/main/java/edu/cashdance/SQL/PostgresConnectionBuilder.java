package edu.cashdance.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static edu.cashdance.App.logger;

public class PostgresConnectionBuilder {
    public static Connection getConnection() {

        // подгружаем класс по имени (уже необязательно прописывать)
        // Class.forName("org.postgresql.Driver");
        // устанавливаем соединение с сервером
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CashDanceDB", "postgres", "postgres");
        } catch (SQLException e) {
            logger.error(e.getMessage() + " this is error");
            throw new RuntimeException(e);
        }
        System.out.println("Подключение к SQL серверу установлено");
        return con;
    }
}