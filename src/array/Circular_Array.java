package array;

import java.util.HashSet;
import java.util.Set;

public class Circular_Array {

    /**
     * Checks if this array has a complete cycle.
     * That means it visits every index and and ends back at the same start
     * index.
     * @param ar
     * @return
     */
    public static boolean isCircular(int[] ar) {

        Set<Integer> vistitedI = new HashSet<>();
        vistitedI.add(0);

        int startIndex = 0;// We can start anywhere
        int next = ar[startIndex];
        int nextIndex = startIndex;
        int i = 0;
        while(i < ar.length) {
            nextIndex = Math.abs((nextIndex + next) % ar.length);//remainder will make sure that we are not going past end
            next = ar[nextIndex];
            if(vistitedI.contains(nextIndex) && vistitedI.size() == ar.length) {
                return startIndex == nextIndex;//Has to land at our initial start
            } else {
                vistitedI.add(nextIndex);
            }
            i++;
        }
        return false;
    }
}
