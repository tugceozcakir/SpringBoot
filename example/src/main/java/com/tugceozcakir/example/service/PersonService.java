package com.tugceozcakir.example.service;

import com.tugceozcakir.example.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//Bean
@Service
public class PersonService {

    //değeri yoksa 25 olsun.
    @Value("${gizem:25}")
    int value;

    public Person createPerson(String name, String surname, String tc, int birthYear){
        Person person = new Person();
        person.setTc(tc);
        person.setName(name);
        person.setSurname(surname);
        person.setBirthYear(birthYear);

        System.out.println(value);
        return person;








    }
}
