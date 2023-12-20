package com.example.Filter;

import java.util.ArrayList;
import java.util.HashMap;

public class subjectFilter implements Filter{
    private HashMap <String,ArrayList<Email>> subjectEmailFilter = new HashMap<String,ArrayList<Email>>();
    @Override
    public HashMap<String,ArrayList<Email>> emailFilter(ArrayList<Email> emails) {
        for(Email email: emails){
            if(!subjectEmailFilter.containsKey(email.getSubject())){
                subjectEmailFilter.put(email.getSubject(),new ArrayList<Email>());
            }
            subjectEmailFilter.get(email.getSubject()).add(email);
        }
        return subjectEmailFilter;
    }
}
