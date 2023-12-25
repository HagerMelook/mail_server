package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class mailButton {
    command command;

    public mailButton(command command) {
        this.command = command;
    }

    public String press(){
        return command.execute();
    }
    
}
