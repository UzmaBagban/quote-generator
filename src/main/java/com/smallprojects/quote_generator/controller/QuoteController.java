package com.smallprojects.quote_generator.controller;

import com.smallprojects.quote_generator.model.Quote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    @GetMapping("api/quotes/hi")
    public String sayHi(@RequestParam(defaultValue="Friend") String name){
        //returning only string
        return "Hey " + name + "! 🌟 You're doing amazing today. Keep pushing forward!";
    }

    @GetMapping("/api/quotes/hello")
    public Quote sayHello(@RequestParam(required = false) String name) {
        //returning string object
        String quoteContent = "Hey " + name + "! 🌟 You're doing amazing today. Keep pushing forward!";
        return new Quote(1, quoteContent, "Your Inner Voice");
    }
}

