package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParanthesisTest {

    @Test
    void generateParenthesis() {
        Paranthesis s = new Paranthesis();
        s.generateParenthesis(3).forEach(System.out::println);
    }
}