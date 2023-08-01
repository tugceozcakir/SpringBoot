package com.tugceozcakir.qualifierannotationexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReaderController {

    @Autowired
    @Qualifier("getWordFileReader")
    private Reader reader;

    @GetMapping("/reader")
    public String read(){
        return this.reader.readFile();
    }
}
