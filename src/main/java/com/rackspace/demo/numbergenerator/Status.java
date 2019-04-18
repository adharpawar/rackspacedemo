package com.rackspace.demo.numbergenerator;

import org.springframework.stereotype.Component;

@Component
public class Status {

    // we can use project lombok as well here

    int statusCode;
    Integer randomNumber;

    public Status(){}

    Status(int statusCode, Integer randomNumber){
        this.statusCode = statusCode;
        this.randomNumber = randomNumber;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
}
