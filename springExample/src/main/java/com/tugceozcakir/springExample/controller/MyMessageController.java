package com.tugceozcakir.springExample.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyMessageController {

    /*
    //PathVariable
    @GetMapping("/message/{m}")
    public String getMyMessage(@PathVariable("m") String message){
        return "Your message is: " + message;
    }
     */

    @GetMapping("/message")
    public String getMyMessage(@RequestParam String message){
        return "Your message is: " + message;
    }
}
