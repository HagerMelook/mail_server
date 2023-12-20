package com.example.mailserver;

import java.util.ArrayList;
import java.util.HashMap;

public class receiverFilter implements Filter{
    private HashMap <String,ArrayList<Email>> receiverEmailFilter = new HashMap<String,ArrayList<Email>>();
    @Override
    public HashMap<String,ArrayList<Email>> emailFilter(ArrayList<Email> emails) {
        for(Email email: emails){
            if(!receiverEmailFilter.containsKey(email.getReceivername())){
                receiverEmailFilter.put(email.getReceivername(),new ArrayList<Email>());
            }
            receiverEmailFilter.get(email.getReceivername()).add(email);
        }
        return receiverEmailFilter;
    }
}