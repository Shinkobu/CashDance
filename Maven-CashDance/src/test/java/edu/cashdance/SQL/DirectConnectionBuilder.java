package edu.cashdance.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static edu.cashdance.App.logger;

public class DirectConnectionBuilder implements ConnectionBuilder {
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/CashDanceDB",
                "postgres", "postgres");

    }
}
