package math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomTest {

    @Test
    void getRandom() {
        int[] ar = {1,2,3,4};
        Random r = new Random(ar);
        r.shuffle();
        r.reset();
        r.shuffle();
    }
}