package ru.cashdance.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.cashdance.SQL.ConsoleSqlDataGetter;
import ru.cashdance.SQL.PoolConnectionBuilder;
import ru.cashdance.SQL.WebSqlDataGetter;
import ru.cashdance.domain.BankCard;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;


//@Path("/getAllCards")
//@Singleton  // with this annotation MyJerseyServlet will not be destroyed after each request.
public class GetAllCards {

    private static final Logger logger = LogManager.getLogger("StatusLogger");
    private ConsoleSqlDataGetter consoleSqlDataGetter;
    private WebSqlDataGetter webSqlDataGetter;

    @PostConstruct // annotation to run code just after the creation of object
    public void init() {
        logger.info("Start experiment");

        webSqlDataGetter = new WebSqlDataGetter();
        webSqlDataGetter.setConnectionBuilder(new PoolConnectionBuilder()); // makes connection

        logger.info("Connection with DB established");
    }

    @PreDestroy // annotation to run code just before the object is destroyed
    public void destroy() {
        logger.info("Finish experiment");
    }

    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<BankCard> getAllCards() {
        logger.info("Got a GET request:");


        return webSqlDataGetter.allBankCards();
    }


}
