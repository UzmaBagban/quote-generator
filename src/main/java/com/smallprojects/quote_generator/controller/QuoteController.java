package com.smallprojects.quote_generator.controller;

import com.smallprojects.quote_generator.model.Quote;
import com.smallprojects.quote_generator.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    // Endpoint 1: Returns only Quote object
    @GetMapping("api/quotes")
    public Quote getQuote(){
        Quote randomQuote = quoteService.getRandomQuote();
        return  randomQuote;
    }

    // Endpoint 2: Returns personalized string message
    @GetMapping("/api/quotes/")
    public String getPersonalizedQuote(@RequestParam(defaultValue = "Friend") String name) {
        Quote randomQuote = quoteService.getRandomQuote();
        return "Hey " + name + "! Here's a quote for you: " +
                randomQuote.getContent() + " - " + randomQuote.getAuthor();
    }

    @GetMapping("api/quotes/hi")
    public String sayHi(@RequestParam(defaultValue="Friend") String name){
        //returning only string
        return "Hey " + name + "! 🌟 You're doing amazing today. Keep pushing forward!";
    }


    @GetMapping("/api/quotes/hello")
    public Quote sayHello(@RequestParam(defaultValue = "Friend") String name) {
        // Get a random Quran quote from service
        Quote randomQuote = quoteService.getRandomQuote();

        // Personalize the message with user's name
        String personalizedMessage = "Hey " + name + "! 🌟 Here's a quote for you:\n\n"
                + randomQuote.getContent();

        // Return the personalized quote
        return new Quote(randomQuote.getId(), personalizedMessage, randomQuote.getAuthor());
    }
}

