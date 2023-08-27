package edu.cashdance.web.training;

import edu.cashdance.CashDanceApp;
import edu.cashdance.domain.BankCard;
import edu.cashdance.domain.CbCategory;
import edu.cashdance.domain.CbChance;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;


//@Path("/check")
public class MyJerseyServlet4 {

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
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CbChance checkPerson(CbChance chance1) {



        return chance1;
    }

}
