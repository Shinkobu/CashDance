package edu.cashdance.server.greet;

import edu.cashdance.server.Greetable;

public class DayGreet extends Greetable {

    @Override
    public String buildResponse(String userName) {
        return "Good day " + userName;
    }
}
