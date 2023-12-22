package com.example.Backend;

import java.util.Comparator;
import java.util.List;

public class ImportanceSortingStrategy implements SortingStrategy {
    @Override
    public void sort(List<Email> emails) {
        emails.sort(Comparator.comparing(Email::getImportance, new ImportanceComparator()));
    }

    private static class ImportanceComparator implements Comparator<String> {
        private static final String[] IMPORTANCE_ORDER = {"high", "medium", "low"};

        @Override
        public int compare(String importance1, String importance2) {
            int index1 = getIndex(importance1);
            int index2 = getIndex(importance2);

            return Integer.compare(index1, index2);
        }

        private int getIndex(String importance) {
            for (int i = 0; i < IMPORTANCE_ORDER.length; i++) {
                if (IMPORTANCE_ORDER[i].equalsIgnoreCase(importance)) {
                    return i;
                }
            }
            // If not found, return a large value to push it to the end
            return IMPORTANCE_ORDER.length;
        }
    }
}
