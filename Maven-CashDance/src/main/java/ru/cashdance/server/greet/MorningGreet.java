package ru.cashdance.server.greet;

import ru.cashdance.server.Greetable;

public class MorningGreet extends Greetable {

    @Override
    public String buildResponse(String userName) {
        return "Good morning " + userName;
    }
}
