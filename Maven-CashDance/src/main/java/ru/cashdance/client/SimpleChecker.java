package ru.cashdance.client;
/*
lesson 107
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.cashdance.config.Config;
import ru.cashdance.domain.BankCard;
import ru.cashdance.web.BankCardRequest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class SimpleChecker {

    public static void main(String[] args) {

        SimpleChecker simpleChecker = new SimpleChecker();
        BankCardRequest bankCardRequest = new BankCardRequest();

        for (int i = 0; i < 6; i++) {
            bankCardRequest.setIndex(i);
            System.out.println(simpleChecker.checkBankCard(bankCardRequest));
        }
    }

    public BankCard checkBankCard (BankCardRequest bankCardRequest){
        Client client = ClientBuilder.newClient();

        /*
        target - where the request will be sent
        request - what I send in request
        post - it will be post

         */

        BankCard bankCard = client.target(Config.getProperty(Config.CD_URL))
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(bankCardRequest, MediaType.APPLICATION_JSON))
                .readEntity(BankCard.class);

        return bankCard;

    }
}
