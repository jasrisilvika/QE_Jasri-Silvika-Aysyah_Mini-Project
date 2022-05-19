package com.example.app.Utils;

import java.util.Random;

public class General {
    Random rand = new Random();

    public String randomEmail() {
        return "mobileUser" + +rand.nextInt(1000) + "@yahoo.com";
    }
}
