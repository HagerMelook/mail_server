package com.example.mailserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FilterDemo {
    public static void main(String[] args) throws IOException {
        ArrayList <Email> email_list = new ArrayList<>();
        Email email = new Email("Hager Melook","Nouran Ashraf","Hello","hagermelook@gmail.com","social");
        email_list.add(email);
        // //createUserJson saveEmail = new createUserJson(email,"./messages");
        //saveEmail.createUserJSON(email,"./messages");
        email = new Email("Nouran Ashraf","Hager Melook","Do your work","NouranAshraf@gmail.com","business");
        email_list.add(email);
        // //saveEmail.createUserJSON(email,"./messages");
        email = new Email("Hager Melook","Rana Mohammed","No","hagermelook@gmail.com","social");
        email_list.add(email);
        // //saveEmail.createUserJSON(email,"./messages");
        email = new Email("Rana Mohammed","Hager Melook","Good idea, I'm with you","Ranamohammed@gmail.com","social");
        email_list.add(email);
        //saveEmail.createUserJSON(email,"./messages");
        receiverFilter receiverFilter = new receiverFilter();
        HashMap<String,ArrayList<Email>> emails = receiverFilter.emailFilter(email_list);
        ArrayList<Email>email2 = emails.get("Hager Melook");
        subjectFilter subjectFilter = new subjectFilter();
        emails = subjectFilter.emailFilter(email2);
        email2 = emails.get("social");
        System.out.println(email2.size());
        for(Email email1: email2)
        System.out.println(email1.getText());
    }
}
