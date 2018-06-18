package math.binary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryTest {

    @Test
    void addBinary() {
        AddBinary add = new AddBinary();
        String f = "1";
        String g = "0";
        String sum = add.addBinary(f, g);
        assertEquals(addBinary(f, g), sum);

        String x = "0110010";
        String y = "0011011";
        sum = add.addBinary(x, y);
        System.out.println();
        assertEquals(addBinary(x, y), sum);
    }

    static String addBinary(String a, String b) {

        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Travers both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (char)(s % 2 + '0') + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--; j--;
        }

        return result;
    }
}