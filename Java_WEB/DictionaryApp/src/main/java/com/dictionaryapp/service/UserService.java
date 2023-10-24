package com.dictionaryapp.service;

import com.dictionaryapp.validation.UserLoginBindingModel;
import com.dictionaryapp.validation.UserRegisterBindingModel;

public interface UserService {
    void registerUser(UserRegisterBindingModel userRegisterBindingModel);

    void loginUser(UserLoginBindingModel userLoginBindingModel);

    void logoutUser();

}
