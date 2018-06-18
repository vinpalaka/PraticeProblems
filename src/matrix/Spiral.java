package matrix;

import java.util.LinkedList;
import java.util.List;

public class Spiral {
    public List<Integer> spiralOrder(int[][] matrix) {
        if( matrix.length == 0 || matrix == null)
            return new LinkedList<Integer>();
        int top = 0;
        int bottom = matrix.length -1;
        int left = 0;
        int right = matrix[0].length -1;
        List<Integer> list = new LinkedList<Integer>();

        while(true) {
            if(left > right)
                break;
            for(int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            if(top > bottom)
                break;
            for(int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if(left > right)
                break;
            for(int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if(top > bottom)
                break;
            for(int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
