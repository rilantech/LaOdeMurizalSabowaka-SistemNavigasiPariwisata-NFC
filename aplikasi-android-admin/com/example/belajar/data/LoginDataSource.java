package com.example.belajar.data;

import com.example.belajar.data.Result;
import com.example.belajar.data.model.LoggedInUser;
import java.io.IOException;
import java.util.UUID;

public class LoginDataSource {
    public Result<LoggedInUser> login(String username, String password) {
        try {
            return new Result.Success(new LoggedInUser(UUID.randomUUID().toString(), "Jane Doe"));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
    }
}
