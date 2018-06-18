package math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetSumTest {

    @Test
    void findTargetSumWays() {
        int[] nums = {1,1,1,1,1};
        TargetSum.findTargetSumWays(nums, 3);
    }
}