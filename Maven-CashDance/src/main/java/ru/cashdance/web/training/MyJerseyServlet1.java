package ru.cashdance.web.training;


import ru.cashdance.domain.BankCard;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/checkOne")
public class MyJerseyServlet1 {

    /*
        Parameters transmission example. 1) by Path 2) by Query
        http://localhost:8080/Maven-CashDance-1.0/rest/checkOne/SberCard?bankName=Sber

        in this case tomcat will return 999 : Alex

        and moreover it will produce json file - by @Produces

        !!! Produces will return only attributes with both getters and setters - problem to investigate
    */
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public BankCard checkPerson(@PathParam("name") String name,
                                @QueryParam("bankName") String bankName) {

        BankCard bankCard = new BankCard();
        bankCard.setBankName(name);
        bankCard.setName(bankName);

        return bankCard;
    }

}
