package edu.cashdance.web.training;

import edu.cashdance.CashDanceApp;
import edu.cashdance.domain.BankCard;
import edu.cashdance.domain.CbCategory;
import edu.cashdance.domain.CbChance;
import edu.cashdance.domain.CbUser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;


//@Path("/check")
public class MyJerseyServlet3 {

    /*

    */
//    @POST
    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CbChance checkPerson() {

        BankCard bankCard1 = new BankCard();
        bankCard1.setName("Карта Сбера");
        bankCard1.setBankName("Сбербанк");
        CbCategory cat1 = new CbCategory();
        cat1.setName("Аптеки");

        CbChance chance1 = new CbChance();
        chance1.setCard(bankCard1);
        chance1.setName("тестовый шанс 1");
        chance1.setStartDate(LocalDate.parse("01-07-2023", CashDanceApp.oldDateFormatter));
        chance1.setEndDate(LocalDate.parse("31-07-2023", CashDanceApp.oldDateFormatter));
        chance1.setCategory(cat1);
        chance1.setRate(0.01);


        return chance1;
    }

}
