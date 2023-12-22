package com.example.Backend;

import java.util.Comparator;
import java.util.List;

public class SubjectSortingStrategy implements SortingStrategy {
    @Override
    public void sort(List<Email> emails) {
        emails.sort(Comparator.comparing(Email::getSubject));
    }
}