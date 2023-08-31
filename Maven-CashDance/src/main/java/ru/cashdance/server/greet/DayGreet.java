package ru.cashdance.server.greet;

import ru.cashdance.server.Greetable;

public class DayGreet extends Greetable {

    @Override
    public String buildResponse(String userName) {
        return "Good day " + userName;
    }
}
