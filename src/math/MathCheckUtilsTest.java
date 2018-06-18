package math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathCheckUtilsTest {
    MathCheckUtils utils = new MathCheckUtils();

    @Test
    void checkSum() {
        MathCheckUtils checkUtils = new MathCheckUtils();
        String value = checkUtils.checkSum(1, 4, 5, 9);
        assertEquals("Yes", value, "1 and 4 do not reach 5 and 9");
        int a[] = new int[2];
        a[1] =1;
        a[0] =2;
        System.out.println(a);
        System.out.println("===================================================================");

        value = checkUtils.checkSum(1, 4, 5, 14);
        assertEquals("Yes", value, "1 and 4 do not reach 5 and 14");

        System.out.println("===================================================================");

        value = checkUtils.checkSum(1, 4, 5, 8);
        assertEquals("No", value, "1 and 4 do not reach 5 and 8");

        System.out.println("===================================================================");

        value = checkUtils.checkSum(2, 7, 7, 15);
        assertEquals("No", value, "1 and 4 do not reach 5 and 8");
        System.out.println("===================================================================");

        value = checkUtils.checkSum(3, 12, 27, 39);
        assertEquals("Yes", value, "1 and 4 do not reach 5 and 8");

        System.out.println("===================================================================");

        value = checkUtils.checkSum(2, 3, 8, 11);
        assertEquals("Yes", value, "1 and 4 do not reach 8 and 11");

    }

    @Test
    public void testBit() {
        int x = 6;
        int y = 8;
        ;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));

        System.out.println(20 >> 1);
    }

    @Test
    public void getSubStringPermutationCount() {
        String b = "apdace";
        String a = "ace";
        int count = utils.getPerm(a, b);
        System.out.println(count);
    }

    @Test
    public void getCombinationsof() {
        String test = "??0";
        utils.getCombinations(test);
    }

    @Test
    public void printPrimes() {
        String primes = "2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199";
        String numbers = MathCheckUtils.getAllPrime(200);
        assertEquals(primes, numbers);
        numbers = MathCheckUtils.getAllPrime(199);
        assertEquals(primes, numbers);
    }
}