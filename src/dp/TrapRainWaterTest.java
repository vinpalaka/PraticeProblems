package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrapRainWaterTest {

    @Test
    void trap() {
        int[] ar = {0,1,0,2,1,0,1,3,2,1,2,1};
        int sum = TrapRainWater.trap2(ar);
        assertEquals(6, sum);
        int [] ar2 = {4,2,3};
        sum = TrapRainWater.trap(ar2);
        assertEquals(1, sum);
    }
}