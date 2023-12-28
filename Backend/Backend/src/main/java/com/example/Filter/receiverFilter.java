package com.example.Filter;

import java.util.ArrayList;
import java.util.HashMap;

public class receiverFilter implements Filter{
    private HashMap <String,ArrayList<Email>> receiverEmailFilter = new HashMap<String,ArrayList<Email>>();
    @Override
    public HashMap<String,ArrayList<Email>> emailFilter(ArrayList<Email> emails) {
        for(Email email: emails){
            if(!receiverEmailFilter.containsKey(email.getReceiver())){
                receiverEmailFilter.put(email.getReceiver(),new ArrayList<Email>());
            }
            receiverEmailFilter.get(email.getReceiver()).add(email);
        }
        return receiverEmailFilter;
    }
}