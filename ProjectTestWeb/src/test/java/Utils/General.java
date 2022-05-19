package Utils;

import java.util.Random;

    public class General {
        Random rand = new Random();

        public String randomEmail(){
            return "aveeka" + + rand.nextInt(1000) + "@yahoo.com";
        }
    }
