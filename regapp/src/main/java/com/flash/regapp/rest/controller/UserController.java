package com.flash.regapp.rest.controller;

import com.flash.regapp.rest.repository.dto.UserCommentDto;
import com.flash.regapp.rest.repository.dto.UserDto;
import com.flash.regapp.rest.repository.entity.User;
import com.flash.regapp.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/controller")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> user(@RequestParam String email) {
        User user = userService.getUserByUser(email);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.OK);
    }

    @GetMapping("/star")
    public ResponseEntity<UserCommentDto> star(@RequestBody UserCommentDto userCommentDto) {
        return new ResponseEntity<>(userService.getStarComment(userCommentDto),HttpStatus.OK);
    }

    @PutMapping("/passwordrest")
    public ResponseEntity<User> updatePassword(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.updatePassword(userDto), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<String> star(@Param("email") String email,@Param("password") String password) {
        return userService.login(email,password);
    }
}
