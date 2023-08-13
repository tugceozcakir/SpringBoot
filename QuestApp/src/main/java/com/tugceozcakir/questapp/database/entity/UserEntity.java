package com.tugceozcakir.questapp.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "userr")
@Data
public class UserEntity {
    @Id
    Long id;

    String username;
    String password;
}
