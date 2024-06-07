package com.service;

import java.util.HashMap;

public class AuthenticationService {
    private HashMap<String, String> users = new HashMap<>();
    public void register(String username, String password) {
        users.put(username, password);
    }
    public boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
    public void viewUser(){
        for (String user:users.keySet()) {
            System.out.println(user);
        }
    }

}
