package com.disciplinetracker.controller;

import com.disciplinetracker.model.User;
import com.disciplinetracker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class UserController {
  UserService userService;
  public UserController(UserService userService){
      this.userService = userService;
  }
  @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
      User userReq = userService.createUser(user);
      return ResponseEntity.ok(userReq);
  }

}
