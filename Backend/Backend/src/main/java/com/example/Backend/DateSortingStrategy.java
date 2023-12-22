package com.example.Backend;

import java.util.Comparator;
import java.util.List;

public class DateSortingStrategy implements SortingStrategy {
    @Override
    public void sort(List<Email> emails) {
        emails.sort(Comparator.comparing(Email::getDate, Comparator.reverseOrder()));
    }
}
