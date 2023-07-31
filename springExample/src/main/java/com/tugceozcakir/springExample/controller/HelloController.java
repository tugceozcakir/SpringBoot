package com.tugceozcakir.springExample.controller;

import com.tugceozcakir.springExample.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HelloController {
    // localhost:8080/api/hello

    //@GetMapping(path = "/hello")
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello World";
    }


    @PostMapping("/save")
    public String save(){
        return "Data saved!";
    }

    @DeleteMapping("/delete")
    public String delete(){
        return "Data deleted!";
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        System.out.println("User saved!");
        return user;
    }

    @PostMapping("/users")
    public List<User> getAllUser(@RequestBody List<User> users){
        System.out.println("All user saved");
        users.forEach(user -> user.setAge(50));
        return users;
    }

    @GetMapping("/header")
    public String getHeader(@RequestHeader("My-Header") String myHeader){
        return "Your header is: " + myHeader;
    }
}
