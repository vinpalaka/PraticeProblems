package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionUtilTest {
    RecursionUtil util = new RecursionUtil();

    @Test
    public void isPrime() {
        assertFalse(RecursionUtil.isPrime(30));
        assertFalse(RecursionUtil.isPrime(15));
        assertFalse(RecursionUtil.isPrime(4));
        assertFalse(RecursionUtil.isPrime(39));
        assertFalse(RecursionUtil.isPrime(49));
        assertTrue(RecursionUtil.isPrime(11));
        assertTrue(RecursionUtil.isPrime(17));
        assertTrue(RecursionUtil.isPrime(5));
        assertTrue(RecursionUtil.isPrime(47));
        assertTrue(RecursionUtil.isPrime(73));
    }

    @Test
    public void getSUm() {
        int[] ar = {-5 ,4, -2, 3, -9, 1, 5, 10};
        int max = util.getSum(0, Integer.MIN_VALUE, ar, 0 );
        assertEquals(maxSubArraySum(ar), max);
    }

    //Test with
    private static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

}