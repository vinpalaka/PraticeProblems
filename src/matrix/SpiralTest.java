package matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpiralTest {

    @Test
    void spiralOrder() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Spiral ma = new Spiral();
        List<Integer> l = ma.spiralOrder(matrix);
        List<Integer> correctList = new LinkedList<>(Arrays.asList(1,2,3,6,9,8,7,4,5));
        assertEquals(l, correctList);

        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> l2 = ma.spiralOrder(matrix2);
        System.out.println(l2);

        int[][] matrix3 = {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20},{21,22,23,24,25,26,27,28,29,30},{31,32,33,34,35,36,37,38,39,40}};
        List<Integer> l3 = ma.spiralOrder(matrix3);

        int[][] matrix4 = {{1,2,},{11,12,},{21,22,},{31,32,}};
        List<Integer> l4 = ma.spiralOrder(matrix4);
        System.out.println(l4);


    }
}