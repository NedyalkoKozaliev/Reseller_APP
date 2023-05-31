package com.SoftUniExam180223.Reseller_APP.Service;

import com.SoftUniExam180223.Reseller_APP.Model.Entity.User;
import com.SoftUniExam180223.Reseller_APP.Model.Service.UserServiceModel;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByNameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findUserByUsername(String value);

    User findUserByEmail(String value);
}
