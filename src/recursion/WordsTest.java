package recursion;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordsTest {

    @Test
    void split() {

        String text = "helloworld!";
        Set<String> dictionary = new HashSet<>();
        dictionary.add("he");
        dictionary.add("hell");
        dictionary.add("low");
        dictionary.add("hello");
        dictionary.add("world");
        dictionary.add("!");


        List<String> words = Words.splitnow(text, dictionary);

        for (String word: words){
            System.out.println(word);
        }
    }
}