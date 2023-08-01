package com.tugceozcakir.springtaskmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
}
