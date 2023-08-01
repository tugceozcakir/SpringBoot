package com.tugceozcakir.lazyannotation;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    MyComponent myComponent;

    public MyController(MyComponent myComponent) {
        this.myComponent = myComponent;
    }
}
