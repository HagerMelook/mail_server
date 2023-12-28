package com.example.Filter;

import java.util.ArrayList;
import java.util.HashMap;


public class senderFilter implements Filter{
    private HashMap <String,ArrayList<Email>> senderEmailFilter = new HashMap<String,ArrayList<Email>>();
    @Override
    public HashMap <String,ArrayList<Email>> emailFilter(ArrayList <Email> emails) {
        for(Email email: emails){
            if(!senderEmailFilter.containsKey(email.getSender())){
                senderEmailFilter.put(email.getSender(),new ArrayList<Email>());
            }
            senderEmailFilter.get(email.getSender()).add(email);
        }
        return senderEmailFilter;
    }
    
}
