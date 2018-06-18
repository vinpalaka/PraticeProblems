package search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchRangeTest {

    @Test
    void isInRange() {
        String encodedMessage = "hello";

            StringBuilder b = new StringBuilder();
            for (int i = 0; i < encodedMessage.length(); i++) {
                char c = encodedMessage.charAt(i);
                c += c + i;
                b.append(c);
            }
        String  encoded =    b.reverse().toString();

        String text = new StringBuilder(encoded).reverse().toString();
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int m = text.charAt(i) -i ;
           m = m/2 ;
           c = (char) m;
            message.append(c);
        }
        System.out.println(message.toString());
    }
}