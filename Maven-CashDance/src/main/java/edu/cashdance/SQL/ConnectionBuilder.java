package edu.cashdance.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {
    public static Connection getConnection() throws SQLException {

        // подгружаем класс по имени (уже необязательно прописывать)
        // Class.forName("org.postgresql.Driver");
        // устанавливаем соединение с сервером
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CashDanceDB", "postgres", "postgres");
        System.out.println("Подключение к SQL серверу установлено");
        return con;
    }
}