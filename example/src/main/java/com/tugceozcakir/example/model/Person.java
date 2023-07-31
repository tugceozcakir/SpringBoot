package com.tugceozcakir.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//bu anotasyonu koyduğumuzda getter setter constructor'ı oluşturur.
//sadece getter istiyorsak @Getter
//NoArgsConstructor ile sadece constructor oluşturur. girdiğimiz fieldlara göre oluşturur.
@Getter
@Setter
public class Person {
    private String name;
    private String surname;
    private int birthYear;
    private String tc;
}
