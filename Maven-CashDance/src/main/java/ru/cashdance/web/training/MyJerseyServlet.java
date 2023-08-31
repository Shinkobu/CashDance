package ru.cashdance.web.training;

import javax.ws.rs.*;

@Path("/checkZero")
public class MyJerseyServlet {

    /*
        Parameters transmission example. 1) by Path 2) by Query
        http://localhost:8080/Maven-CashDance-1.0/rest/checkZero/999?name=Alex

        in this case tomcat will return 999 : Alex
    */
    @GET
    @Path("/{id}")
    public String myTestServlet1 (@PathParam("id") int simpleId,
                              @QueryParam("name") String simpleName) {
        return simpleId + " : " + simpleName;
    }

}
