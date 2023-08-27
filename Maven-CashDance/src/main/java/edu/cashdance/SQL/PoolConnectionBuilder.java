package edu.cashdance.SQL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder{

    public static final Logger logger = LogManager.getLogger("StatusLogger");
    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private DataSource dataSource;

    public PoolConnectionBuilder(){
        try{
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/CashDance");
        } catch (NamingException e) {
            logger.error("Error! " + e);
            throw new RuntimeException();
        }
    }
}
