package java8.javaRandom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    void copyArray() {
        int[] ar = {1, 2};
        ArrayUtils utils = new ArrayUtils();
        utils.topKFrequent(ar, 2);
    }
}