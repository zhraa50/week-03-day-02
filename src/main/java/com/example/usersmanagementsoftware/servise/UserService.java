package com.example.usersmanagementsoftware.servise;

import UserRepository.UserRepository;
import com.example.usersmanagementsoftware.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;



    //-----------get  users
    public  List <UserModel> getUser() {
        return userRepository.findAll();
    }

    //add user----------------------
        public   void addUser (UserModel user)
        {
        userRepository.save(user);
    }

//------------------------------------------------
public UserModel getUserById(String id) {
    return userRepository.findById(id);
}

    public UserModel getUserByEmail(String Email) {
        return userRepository.findByEmail(Email);

    }

    public UserModel getUserByAge(Integer Age) {
        return userRepository.findByAge(Age);

    }


    public UserModel getUserByRole(String role) {
        return userRepository.findByAge(role);
    }

//---------------------------------------------------
public  UserModel getUserByUserNameAndPassword(String userName, Integer passWord) {
    return userRepository.fineByUserNameAndPassword(userName,passWord);


}

//-------------------------------------------------
    public UserModel UpdateUser(UserModel NewUser, Integer id) {
        UserModel oldUser =userRepository.findById(id).get();
        if (NewUser.getId().equals(id ))
        oldUser.setEmail(NewUser.getEmail());
        oldUser.setPassword(NewUser.getPassword());
        oldUser.setUsername(NewUser.getUsername());
        return userRepository.save(NewUser);

    }

}
