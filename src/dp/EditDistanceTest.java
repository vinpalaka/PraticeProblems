package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    @Test
    void minDistance() {
        System.out.println(EditDistance.minDistance("abac", "fbcde"));
    }
}