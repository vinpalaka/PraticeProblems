package math.binary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifferentBitsTest {

    @Test
    void hammingDistance() {
        DifferentBits bits = new DifferentBits();
        bits.hammingDistance(1, 4);
        System.out.println(Integer.toBinaryString(4));
    }
}