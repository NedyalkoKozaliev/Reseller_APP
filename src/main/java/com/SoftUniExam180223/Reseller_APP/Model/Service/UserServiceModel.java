package com.SoftUniExam180223.Reseller_APP.Model.Service;

public class UserServiceModel {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
