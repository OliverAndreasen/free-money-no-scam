package com.example.freemoneynoscam.services;
import com.example.freemoneynoscam.models.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    private DatabaseService databaseService;
    private ArrayList<User> users = new ArrayList<User>();

    public UserService() {
        this.databaseService = new DatabaseService();
        try {
            this.users = databaseService.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUserById(int id){
        for(User user : users){
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void insertUserToDb(String email){
        String sql = "INSERT INTO users (`email`) VALUES ('" + email + "')";
        databaseService.insertStatement(sql);
    }
}
