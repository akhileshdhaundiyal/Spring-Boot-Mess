package com.boot1.backend.RestOne;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class RestOneController {    
    
    @GetMapping("/restOne")
    public String home() {

        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject(
					"https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return quote.toString();
    }

    @GetMapping("/restOneArgs")
    public String withArgs(@RequestParam String name, String game) {

        return "H E L L O " + name + ", 10/10 in " + game;
    }
    
}