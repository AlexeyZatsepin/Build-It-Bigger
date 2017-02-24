package study.gradlecoursefinalproject;

import java.util.Random;

public class ContentProvider {
    private static String[] jokes = new String[]{
            "Joke1",
            "Joke2",
            "Joke3",
            "Joke4",
            "Joke5",
            "Joke6",
            "Joke7",
            "Joke8",
            "Joke9",
            "Joke10"
    };

    public static String getJoke(){
        return "Joke of the day: "+ jokes[Math.abs(new Random().nextInt()%jokes.length)];
    }

}
