package com.likebookapp.service.impl;

import com.likebookapp.model.binding.UserLoginBindingModel;
import com.likebookapp.model.binding.UserRegisterBindingModel;
import com.likebookapp.model.entity.User;
import com.likebookapp.model.sec.CurrentUser;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return;
        }

         String encodePass = passwordEncoder.encode(user.getPassword());
         user.setPassword(encodePass);

         userRepository.save(user);

    }

    @Override
    public void loginUser(UserLoginBindingModel userLoginBindingModel) {

        User user = userRepository.findByUsername(userLoginBindingModel.getUsername());
        if (user == null) {
            throw new IllegalArgumentException();
        }

        if (!passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException();
        }

        currentUser.setId(user.getId());
        currentUser.setUsername(user.getUsername());



    }
}
