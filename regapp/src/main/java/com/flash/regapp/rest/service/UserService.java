package com.flash.regapp.rest.service;

import com.flash.regapp.config.DataMissMatchException;
import com.flash.regapp.config.StarUtil;
import com.flash.regapp.rest.repository.UserRepository;
import com.flash.regapp.rest.repository.dao.UserDao;
import com.flash.regapp.rest.repository.dto.UserCommentDto;
import com.flash.regapp.rest.repository.dto.UserDto;
import com.flash.regapp.rest.repository.entity.User;
import com.flash.regapp.rest.repository.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    StarUtil starUtil;
    UserDao userDao;

    public UserService(UserMapper userMapper, UserRepository userRepository, StarUtil starUtil, UserDao userDao) {
        this.userRepository = userRepository;
        this.starUtil = starUtil;
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    public User getUserByUser(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(UserDto user) {
        User userToSave = userMapper.toUserFromDto(user);
        userToSave.setPasswordResetCode(passwordResetCodeTransform(user.getPassword()));
        return userRepository.save(userToSave);
    }

    public UserCommentDto getStarComment(UserCommentDto userCommentDto) {
        userCommentDto.setComment(starUtil.getStarwords(userCommentDto.getComment()));
        return userCommentDto;

    }

    public ResponseEntity<String> login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (Objects.isNull(user) || !user.getPassword().equals(password)) {
            return new ResponseEntity<>("Incorrect Login Credentials", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>( "Login Successful", HttpStatus.ACCEPTED);
    }

    public User updatePassword(UserDto user) {
        UserDto userPassResCode = userDao.getUserDao(user.getEmail(),user.getPasswordResetCode());
        if (Objects.isNull(userPassResCode)) {
            throw new DataMissMatchException("The password reset code you entered is incorrect");
        }
        User userUpdate = userRepository.findByEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());
        userUpdate.setPasswordResetCode(passwordResetCodeTransform(user.getPassword()));
        return userRepository.save(userUpdate);
    }

    public String passwordResetCodeTransform(String password){
        return java.util.UUID.nameUUIDFromBytes(password.getBytes()).toString();
    }
}
