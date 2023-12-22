package com.example.Backend;

import java.util.List;

public class EmailSorterContext {
    private SortingStrategy sortingStrategy;

    public EmailSorterContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sortEmails(List<Email> emails) {
        sortingStrategy.sort(emails);
    }
}