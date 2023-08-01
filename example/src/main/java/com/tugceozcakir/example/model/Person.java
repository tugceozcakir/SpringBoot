package com.tugceozcakir.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

//bu anotasyonu koyduğumuzda getter setter constructor'ı oluşturur.
//sadece getter istiyorsak @Getter
//NoArgsConstructor ile sadece constructor oluşturur. girdiğimiz fieldlara göre oluşturur.
@Getter
@Setter
@AllArgsConstructor
public class Person {
    private UUID uuid;
    private String name;
    private String surname;
    private int birthYear;
    private String tc;

    public Person(UUID uuid) {
        this.uuid = UUID.randomUUID();
    }
    public Person() {
    }

}
