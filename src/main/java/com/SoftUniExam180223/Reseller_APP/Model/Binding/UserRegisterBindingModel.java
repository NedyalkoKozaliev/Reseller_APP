package com.SoftUniExam180223.Reseller_APP.Model.Binding;

import com.SoftUniExam180223.Reseller_APP.Validation.annotation.UniqueEmail;
import com.SoftUniExam180223.Reseller_APP.Validation.annotation.UniqueUsername;
import jakarta.validation.constraints.*;

public class UserRegisterBindingModel {
    @UniqueUsername(message = "Username should be unique.")
    @NotEmpty(message = "Username could not be blank.")
    @Size(min=3, max=20, message = "Username length must be between 3 and 20 characters.")
    private String username;
    @NotEmpty(message = "Password could not be blank.")
    @Size(min=3, max=20, message = "Password length must be between 3 and 20 characters.")
    private String password;
    @UniqueEmail
    @NotEmpty(message = "Email could not be blank.")
    @Email(message = "Please provide valid email address.")
    private String email;
    @NotEmpty(message = "Field could not be blank.")
    @Size(min=3, max=20)
    private String confirmPassword;



    public UserRegisterBindingModel() {
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
