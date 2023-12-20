package com.example.mailserver;

import java.util.ArrayList;
import java.util.HashMap;


public class senderFilter implements Filter{
    private HashMap <String,ArrayList<Email>> senderEmailFilter = new HashMap<String,ArrayList<Email>>();
    @Override
    public HashMap <String,ArrayList<Email>> emailFilter(ArrayList <Email> emails) {
        for(Email email: emails){
            if(!senderEmailFilter.containsKey(email.getSendername())){
                senderEmailFilter.put(email.getSendername(),new ArrayList<Email>());
            }
            senderEmailFilter.get(email.getSendername()).add(email);
        }
        return senderEmailFilter;
    }
    
}
