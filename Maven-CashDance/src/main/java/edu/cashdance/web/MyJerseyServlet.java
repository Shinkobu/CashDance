package edu.cashdance.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/check")
public class MyJerseyServlet {
@GET
    public String checkPerson(){
    return "SimpleString";
}

}
