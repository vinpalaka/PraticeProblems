package math.binary;

import java.util.*;
import java.util.stream.IntStream;

public class CountBits {
    public int[] countBits(int num) {
        return IntStream.range(0, num + 1)
                .map(x -> Integer.bitCount(x))
                .toArray();

    }

    public int[] countBits2(int num) {
        Comparator<int[]> c = (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            else {
                return b[0] - a[0];
            }
        };
        int[][]p = null;

        List<int[]> m = new ArrayList<>();
        m.toArray(new int[p.length][2]);

        Arrays.sort(p, c);
        int[] ar = new int[num + 1];
        for(int i = 0; i < ar.length; i++)
            ar[i]=Integer.bitCount(i);
        return ar;

    }
}
