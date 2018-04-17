package com.example.batman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "Hello World!";
    }

    @RequestMapping("/wow/woody/rocks")
    public String woody() {
        return "Wow woody rocks!";
    }
}
