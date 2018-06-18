package recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubsetsTest {

    @Test
    void subsets() {
        Subsets s = new Subsets();
        int [] ar = {1,2,3};
        List<List<Integer>> lists = s.subsets(ar);
        System.out.println(lists);
    }
}