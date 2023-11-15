package com.SoftUniExam180223.Reseller_APP.Service.Impl;

import com.SoftUniExam180223.Reseller_APP.Current.CurrentUser;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.User;
import com.SoftUniExam180223.Reseller_APP.Model.Service.UserServiceModel;
import com.SoftUniExam180223.Reseller_APP.Repository.UserRepository;
import com.SoftUniExam180223.Reseller_APP.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //private final MyOwnMapper myMapper;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser, PasswordEncoder encoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.encoder = encoder;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        //User user=modelMapper.map(userServiceModel, User.class);
        User user = new User();

        user.setUsername(userServiceModel.getUsername());
        user.setEmail(userServiceModel.getEmail());
        user.setPassword(encoder.encode(userServiceModel.getPassword()));
        userRepository.save(user);

        return modelMapper.map(userRepository.findByEmail(user.getEmail()), UserServiceModel.class);
//        User user=modelMapper.map(userServiceModel, User.class);
//        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByNameAndPassword(String username, String password) {
       // String pass= encoder.encode(password);

        User user=userRepository.findByUsername(username).orElse(null);

        if(user==null|| !encoder.matches(password, user.getPassword())){
            return null;
        }
        return modelMapper.map(user,UserServiceModel.class);



    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public User findUserByUsername(String value) {
       return userRepository.findByUsername(value).orElse(null);}

    @Override
    public User findUserByEmail(String value) {
        return userRepository.findByEmail(value).orElseThrow(null);

    }

}
