package com.example.usersmanagementsoftware.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class UserModel {
    private Integer ID;
    private String Username;
    private Integer password;
    private String email;
    private String role;
    private String joiningYear ;
    private String age;
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
