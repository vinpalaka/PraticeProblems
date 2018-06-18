package search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchRange {
    class Range {
        int low;
        int high;
    }

    public boolean isInRange(int key, List<Range> range) {
        TreeMap<Integer, Range> treeMap = new TreeMap<>();
        ArrayList s;

        for(Range r : range) {
            treeMap.put(r.low, r);
        }
        treeMap.lowerKey(key);
        return true;
    }
}
