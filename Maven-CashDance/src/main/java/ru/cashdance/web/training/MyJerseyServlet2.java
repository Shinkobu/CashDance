package ru.cashdance.web.training;

import ru.cashdance.domain.*;
import ru.cashdance.domain.CbUser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/checkTwo")
public class MyJerseyServlet2 {

    /*
        http://localhost:8080/Maven-CashDance-1.0/rest/checkTwo
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CbUser checkPerson() {
        CbUser cbUser = new CbUser();
        cbUser.setName("aaaaaaAAAAA");
        cbUser.setPhoneNumber("99999");

        return cbUser;
    }

}
