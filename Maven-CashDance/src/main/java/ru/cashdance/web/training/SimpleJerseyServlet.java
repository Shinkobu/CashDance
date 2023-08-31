package ru.cashdance.web.training;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/simple")
public class SimpleJerseyServlet {

    /*
            http://localhost:8080/Maven-CashDance-1.0/rest/simple
     */
    @GET
    public String myTestServlet1 () {
        return "Simple sevlet works!";
    }

}
