package com.SoftUniExam180223.Reseller_APP.Model.Binding;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @Size(min=3, max=20)
    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Size(min=3, max=20)
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
