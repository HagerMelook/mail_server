package com.example.Backend;


public class SortingStrategyFactory {

 public SortingStrategy createSortingStrategy(String sortingStrategy) {
     switch (sortingStrategy) {
         case "sender":
             return new SenderSortingStrategy();
         case "date":
             return new DateSortingStrategy(); 
         case "receiver":
             return new ReceiverSortingStrategy();
         case "importance":
             return new ImportanceSortingStrategy();
         case "subject":
             return new SubjectSortingStrategy();
         case "attachments":
             return new AttachmentSortingStrategy();
         default:
             throw new IllegalArgumentException("Invalid sorting strategy: " + sortingStrategy);
     }
 }
}
