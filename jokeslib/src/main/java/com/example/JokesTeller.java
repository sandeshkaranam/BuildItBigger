package com.example;

import java.util.Random;

public class JokesTeller {
    public static String tellJoke(){
        String[] jokes = {"Programmer - A machine that turns coffee into code!",
                "Algorithm - Word used by programmers when they dont want to explain what they did!",
                "Q: Whats the object oriented way to become wealthy?\n A: Inheritance!",
                "Q: What is a programmers favourite hangout place?\n A: Foo Bar!",
                "Q: 0 is false and 1 is true right?\n A: 1",
                "Q: What do computers and air conditioners have in common\n A: They both become useless when you open Windows",
                "Chuck Norris writes code that optimizes itself!",
                "A foo walks into a bar, takes a look around and says \"Hello World\"",
                "A SQL query goes into a bar, walks up to two tables and asks....\"Can I Join you?\"",
                "There are 10 types of people: those who understand binary, and those who do not understand it."
        };
        Random random = new Random();
        int randomInt = random.nextInt(10);
        if(jokes[randomInt]!=null){
            return jokes[randomInt];
        }
        return null;
    }
}
