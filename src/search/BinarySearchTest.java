package search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void binarySearch() {
        int[] ar = {1, 3, 5, 6, 8, 11, 13, 18, 19, 20, 40, 50};
        BinarySearch b = new BinarySearch();
        assertTrue(b.binarySearch(ar, 19));
        assertTrue(b.binarySearch(ar, 1));
        assertTrue(b.binarySearch(ar, 20));
        assertTrue(b.binarySearch(ar, 3));
        assertTrue(b.binarySearch(ar, 6));
        assertTrue(b.binarySearch(ar, 40));

        assertFalse(b.binarySearch(ar, 100));
        assertFalse(b.binarySearch(ar, 2));
        assertFalse(b.binarySearch(ar, 41));



    }
}