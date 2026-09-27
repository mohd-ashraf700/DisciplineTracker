package com.disciplinetracker.controller;

import com.disciplinetracker.model.User;
import com.disciplinetracker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/user")
public class UserController {
  UserService userService;
  public UserController(UserService userService){
      this.userService = userService;
  }
  @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
      User userReq = userService.createUser(user);
      return ResponseEntity.ok(userReq);
  }

  @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
      User getUser = userService.getUser(id);
      return ResponseEntity.ok(getUser);
  }

  @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
      List<User> users = userService.getAllUsers();
      return ResponseEntity.ok(users);
  }
}
