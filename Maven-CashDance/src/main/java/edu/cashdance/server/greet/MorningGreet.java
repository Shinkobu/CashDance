package edu.cashdance.server.greet;

import edu.cashdance.server.Greetable;

public class MorningGreet extends Greetable {

    @Override
    public String buildResponse(String userName) {
        return "Good morning " + userName;
    }
}
