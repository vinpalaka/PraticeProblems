package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    void isPalindrome() {
        String w = "A man, a plan, a canal: Panama";
        boolean m = Palindrome.isPalindrome(w);
        System.out.println(m);
    }
}