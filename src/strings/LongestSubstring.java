package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 1;
        for(int i = 0, j = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                if(j< map.get(c))
                    j = map.get(c);
            }
            max = Math.max(i-j+1, max);
            map.put(c, i + 1);
        }

        return max;
    }
}
