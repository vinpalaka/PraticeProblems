package search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindDuplicateTest {

    @Test
    void findDuplicate() {
        int[] ar = {1, 2, 3, 4, 5, 2, 6, 27, 8, 9};
        FindDuplicate s = new FindDuplicate();
        int m = s.findDuplicate(ar);
        System.out.println(m);
    }
}