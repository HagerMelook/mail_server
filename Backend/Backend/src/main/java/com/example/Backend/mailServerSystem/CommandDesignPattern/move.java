package com.example.Backend.mailServerSystem.CommandDesignPattern;

import com.example.Backend.mailServerSystem.FacadeDesignPattern.MailCreatorFacade;

public class move implements command{

    mailServerButtons move;

    public move(mailServerButtons move) {
        this.move = move;
    }

    public String execute(){
        return move.moveEmail();
    }
    
}
