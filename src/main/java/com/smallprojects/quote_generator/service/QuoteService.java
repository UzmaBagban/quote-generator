package com.smallprojects.quote_generator.service;

import com.smallprojects.quote_generator.model.Quote;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class QuoteService {

    //store multiple quotes in a list
    private List<Quote> quotes = Arrays.asList(
            new Quote(1, "Allah does not burden a soul beyond its capacity.", "Quran 2:286"),
            new Quote(2, "Indeed, with hardship comes ease.", "Quran 94:5-6"),
            new Quote(3, "In the remembrance of Allah do hearts find rest.", "Quran 13:28"),
            new Quote(4, "Do not despair of the mercy of Allah.", "Quran 39:53"),
            new Quote(5, "Do not weaken and do not grieve.", "Quran 3:139"),
            new Quote(6, "Whoever fears Allah, He will make a way out for him.", "Quran 65:2-3"),
            new Quote(7, "Remember Me; I will remember you.", "Quran 2:152"),
            new Quote(8, "Indeed, Allah is with the patient.", "Quran 2:153"),
            new Quote(9, "Do not despair of Allah's mercy.", "Quran 12:87"),
            new Quote(10, "The most noble among you is the most righteous.", "Quran 49:13"),
            new Quote(11, "And rely upon Allah; sufficient is Allah as Disposer of affairs.", "Quran 33:3"),
            new Quote(12, "My success is only through Allah.", "Quran 11:88"),
            new Quote(13, "Allah is the best of planners.", "Quran 8:30"),
            new Quote(14, "Call upon Me; I will respond to you.", "Quran 40:60"),
            new Quote(15, "Indeed, Allah is with those who do good.", "Quran 29:69"),
            new Quote(16, "And speak to people kindly.", "Quran 2:83"),
            new Quote(17, "Indeed, Allah loves those who trust Him.", "Quran 3:159"),
            new Quote(18, "So remember Me; I will remember you.", "Quran 2:152"),
            new Quote(19, "Indeed, prayer prohibits immorality and wrongdoing.", "Quran 29:45"),
            new Quote(20, "And be patient, for Allah does not allow the reward of the righteous to be lost.", "Quran 11:115")
    );

    //step 2 - create a random number picker
   /* private Random random = new Random();

    //step 3 - Method 1- To get one random quote
    public Quote getRandomQuote(){
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex);
    }
    */
    // Method: To get one random quote
    public Quote getRandomQuote(){
        int randomIndex = ThreadLocalRandom.current().nextInt(quotes.size());
        return quotes.get(randomIndex);
    }


}
