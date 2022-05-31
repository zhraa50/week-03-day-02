package com.example.usersmanagementsoftware.controller;

import com.example.usersmanagementsoftware.model.UserModel;
import com.example.usersmanagementsoftware.servise.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")


public class UserController {

    private final UserService userService;

    //-------------------------------------------------

    @GetMapping
    public ResponseEntity<List<UserModel>> getUser() {
        return ResponseEntity.status(200).body(userService.getUser());

    }

    //------------------------------------------
    // add new user
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody @Valid UserModel user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(200).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("USER  added !");
    }

    //---------------------------------------d and return the user with this id

    //id return id
    @GetMapping("id")
    public ResponseEntity<UserModel> getUserById(@RequestParam String id) {
        return ResponseEntity.status(200).body(userService.getUserById(id));

    }

    ///------------------email and return the user with this email
    @GetMapping("email")
    public ResponseEntity<UserModel> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));


    }

    //-----------------------------------return the user with older than this age
    @GetMapping("age")
    public ResponseEntity<UserModel> getUserByAge(@RequestParam Integer age) {
        return ResponseEntity.status(200).body(userService.getUserByAge(age));

    }

//--------------------------------return the total count having this role

    @GetMapping("role")
    public ResponseEntity<UserModel> getUserByRole(@RequestParam String role) {
        return ResponseEntity.status(200).body(userService.getUserByRole(role));


    }

//------------------------------------- takes username and password and check if it's correct or not

    @GetMapping("/username -password")
    public ResponseEntity<UserModel> getUserByUserNameAndPassword(@RequestParam Integer PassWord, @RequestParam String UserName) {
        return ResponseEntity.status(200).body(userService.getUserByUserNameAndPassword(UserName, PassWord));

    }


   //Create endpoint that takes userid and user object , update the olduser object with the
    // new object after verifying the userid belong to admin user

    @PutMapping("/id")
    public ResponseEntity UpdteUsers(@RequestBody UserModel user ,@RequestBody Integer id) {
        userService.UpdateUser(user, id);

        return ResponseEntity.status(200).body("user update ");
    }}


