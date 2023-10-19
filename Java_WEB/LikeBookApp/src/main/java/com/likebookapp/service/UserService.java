package com.likebookapp.service;

import com.likebookapp.model.binding.UserLoginBindingModel;
import com.likebookapp.model.binding.UserRegisterBindingModel;

public interface UserService {
    void registerUser(UserRegisterBindingModel userRegisterBindingModel);

    void loginUser(UserLoginBindingModel userLoginBindingModel);
}
