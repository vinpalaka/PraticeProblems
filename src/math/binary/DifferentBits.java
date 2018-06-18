package math.binary;

public class DifferentBits {

    /**
     * Converts each to string and compares
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        String xBin = Integer.toBinaryString(x);
        String yBin = Integer.toBinaryString(y);

        int i = xBin.length() -1, j = yBin.length()-1, count = 0;
        while(i>=0 && j>=0) {
            count += xBin.charAt(i) ^ yBin.charAt(j);
            i--;
            j--;
        }
        while(i>=0) {
            if(xBin.charAt(i) == '1')
                count++;
            i--;
        }
        while(j>=0) {
            if(yBin.charAt(j) == '1')
                count++;
            j--;
        }
        return count;
    }

    /**
     * Cool way to solve this.
     * @param x
     * @param y
     * @return
     */
    public int hammingDistanceSolution(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
