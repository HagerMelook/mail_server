package com.example.Backend;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RegistrationController {

    private static final String JsonFile = "users.json";

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Registration registration) {
        try {
            // Validate that required fields are not blank
            if (isNullOrEmpty(registration.getUsername()) || isNullOrEmpty(registration.getEmail()) || isNullOrEmpty(registration.getPassword())) {
                return ResponseEntity.status(400).body("Username, email, and password are required for registration.");
            }

            List<Registration> users = readUsersFromJson();
            // Check if the user with the same username or email already exists
            if (userAlreadyExists(users, registration.getUsername(), registration.getEmail())) {
                return ResponseEntity.status(400).body("User with the same username or email already exists");
            }

            // creating a unique ID for each user in order to use them later in login 
            long newUserId = users.isEmpty() ? 1 : users.get(users.size() - 1).getId() + 1;
            registration.setId(newUserId);

            users.add(registration);
            writeUsersToJson(users);

            return ResponseEntity.ok("Registration successful");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error registering user");
        }
    }
    private boolean userAlreadyExists(List<Registration> users, String username, String email) {
        return users.stream()
                .anyMatch(user -> {
                    String userUsername = user.getUsername();
                    String userEmail = user.getEmail();
                    return (userUsername != null && userUsername.equals(username)) &&
                           (userEmail != null && userEmail.equals(email));
                });
    }

    private List<Registration> readUsersFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(JsonFile);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Registration.class));
    }

    private void writeUsersToJson(List<Registration> users) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(JsonFile);
        objectMapper.writeValue(file, users);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Registration loginRequest) {
        if (isNullOrEmpty(loginRequest.getUsername()) || isNullOrEmpty(loginRequest.getPassword())) {
            return ResponseEntity.status(400).body("Username and password are required for login.");
        }

        try {
            List<Registration> users = readUsersFromJson();
            for (Registration user : users) {
                if (user.getUsername().equals(loginRequest.getUsername()) &&
                    user.getPassword().equals(loginRequest.getPassword())) {
                    // Return user data if data match
                    return ResponseEntity.ok(user);
                }
            }
            return ResponseEntity.status(401).body("Invalid email or password");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error logging in");
        }
    }
    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }    
}
