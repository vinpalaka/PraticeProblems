package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Circular_ArrayTest {

    @Test
    void isCircular() {
        int[] ar = {2, 2, -1};
        assertTrue(Circular_Array.isCircular(ar));
        int[] ar2 = {2, 3, -1};
        assertFalse(Circular_Array.isCircular(ar2));

    }
}