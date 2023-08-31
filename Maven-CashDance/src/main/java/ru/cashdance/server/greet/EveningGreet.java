package ru.cashdance.server.greet;

import ru.cashdance.server.Greetable;

public class EveningGreet extends Greetable {

    @Override
    public String buildResponse(String userName) {
        return "Good evening " + userName;
    }
}
