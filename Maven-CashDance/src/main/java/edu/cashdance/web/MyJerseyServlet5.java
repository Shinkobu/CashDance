package edu.cashdance.web;

import edu.cashdance.SQL.ConsoleSqlDataGetter;
import edu.cashdance.SQL.PoolConnectionBuilder;
import edu.cashdance.SQL.WebSqlDataGetter;
import edu.cashdance.domain.BankCard;
import edu.cashdance.domain.CbChance;
import edu.cashdance.domain.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/check")
@Singleton  // with this annotation MyJerseyServlet will not be destroyed after each request.
public class MyJerseyServlet5 {

    /*
{
"startDate": "01.07.2023",
"endDate": "31.07.2023",
"bankCard": {
"bankName": "Сбербанк",
"indexInDb": 0,
"name": "Карта Сбера"
},
"card": {
"bankName": "Сбербанк",
"indexInDb": 0,
"name": "Карта Сбера"
},
"category": {
"name": "Аптеки"
},
"name": "тестовый шанс 1",
"rate": 0.01
}

    */

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BankCard checkEcho(BankCardRequest request) {
        logger.info("Got a POST request: " + request);


        return webSqlDataGetter.findBandCard(request);
    }


}
