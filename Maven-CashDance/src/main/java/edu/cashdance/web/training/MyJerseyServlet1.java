package edu.cashdance.web.training;


//@Path("/checkOne")
public class MyJerseyServlet1 {

    /*
        Parameters transmission example. 1) by Path 2) by Query
        http://localhost:8080/Maven-CashDance-1.0/rest/check/999?name=Alex

        in this case tomcat will return 999 : Alex

        and moreover it will produce json file - by @Produces

        !!! Produces will return only attributes with both getters and setters - problem to investigate
    */
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public PersonResponse checkPerson(@PathParam("id") int simpleId,
//                                      @QueryParam("name") String simpleName) {
//        return new PersonResponse();
//    }

}
