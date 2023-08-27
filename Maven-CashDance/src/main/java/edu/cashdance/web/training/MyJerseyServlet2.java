package edu.cashdance.web.training;

import edu.cashdance.CashDanceApp;
import edu.cashdance.domain.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;


//@Path("/check")
public class MyJerseyServlet2 {

    /*

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
