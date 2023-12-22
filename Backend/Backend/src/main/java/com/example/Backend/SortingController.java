package com.example.Backend;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class SortingController {
    private static final String JsonFile = "users.json";


    @PostMapping(path = "/sort")
    public ResponseEntity<List<Email>> sortEmails(@RequestBody Request request) {
        try {
            List<Registration> users = readUsersFromJson();

            // Find the user by ID
            Registration user = findUserById(users, request.getUserId());

            if (user != null) {
            	List<Email> userEmails = user.getEmails();
                // Determine the sorting strategy based on the request
                SortingStrategy strategy = getSortingStrategy(request.getSortingKeyword());

                // Use the Context class with the specified strategy
                EmailSorterContext sorterContext = new EmailSorterContext(strategy);
                sorterContext.sortEmails(user.getEmails());


                return ResponseEntity.ok(userEmails);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {

            return ResponseEntity.status(500).body(null);
        }
    }

    private Registration findUserById(List<Registration> users, String userId) {
        for (Registration user : users) {
            if (Objects.equals(userId, user.getId() + "")) {
                return user;
            }
        }
        return null; // User not found
    }

    private List<Registration> readUsersFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(JsonFile);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Registration.class));
    }



    private SortingStrategy getSortingStrategy(String sortingStrategy) {

        SortingStrategyFactory factory = new SortingStrategyFactory();
        return factory.createSortingStrategy(sortingStrategy);
    }

}




