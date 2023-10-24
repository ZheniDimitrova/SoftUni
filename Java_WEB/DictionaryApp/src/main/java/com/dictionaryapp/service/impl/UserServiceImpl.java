package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.sec.CurrentUser;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.validation.UserLoginBindingModel;
import com.dictionaryapp.validation.UserRegisterBindingModel;
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

    @Override
    public void logoutUser() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }
}
