package edu.cashdance.server.greet;

import edu.cashdance.server.Greetable;

public class EveningGreet extends Greetable {

    @Override
    public String buildResponse(String userName) {
        return "Good evening " + userName;
    }
}
