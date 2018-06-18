package strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    @Test
    void isOneEditDistance() {
        System.out.println(EditDistance.isOneEditDistance("a", "A"));
        int[] f = new int[]{1,2};
        int[] j = new int[]{1,3};
        System.out.println(Arrays.equals(f, j));
    }
}