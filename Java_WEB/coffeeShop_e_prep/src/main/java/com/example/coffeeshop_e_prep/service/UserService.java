package com.example.coffeeshop_e_prep.service;

import com.example.coffeeshop_e_prep.model.entity.User;
import com.example.coffeeshop_e_prep.model.service.UserServiceModel;
import com.example.coffeeshop_e_prep.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
