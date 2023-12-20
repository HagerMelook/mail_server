package com.example.mailserver;

import java.util.ArrayList;
import java.util.HashMap;

public interface Filter {

    public HashMap<String,ArrayList<Email>> emailFilter(ArrayList<Email> emails);
}