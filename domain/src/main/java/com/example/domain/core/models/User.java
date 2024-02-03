package com.example.domain.core.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private boolean isAdmin;
    private boolean isBlocked;
}
