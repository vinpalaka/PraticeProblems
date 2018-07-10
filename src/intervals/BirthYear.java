package intervals;

import java.util.*;

public class BirthYear {


    public int solution(String S) {
        // write your code in Java SE 8
        int sum = 0;
        for(int i = 0; i < S.length(); i++) {
            sum +=getLen(S.substring(i, S.length()), "", 0);
        }
        return sum;
    }

    public int getLen(String S, String seq, int count) {
        if(count == S.length())
                return getUniqueCharLeng(seq);
        return getUniqueCharLeng(seq) +
                getLen(S, seq+S.charAt(count), count+1);
    }

    /**
     * Gets the length of unique letters in this sequence
     */
    private int getUniqueCharLeng(String s) {
        if(s.length() == 1) {
            return 1;
        } else {
            int count = 0;
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                map.merge(s.charAt(i), 1, (x, y)-> x+y);
            }
            for(Character c : map.keySet()) {
                if(map.get(c) == 1)
                    count++;
            }
            return count;
        }
    }


    /**
     * Find the year with highest population
     *
     * @param lSpans array of birthyears and death years. [[1920 2000], [1988 2090]]
     * @return year of most population
     */
    public int getYear(int[][] lSpans) {
        Arrays.sort(lSpans, Comparator.comparingInt(x -> x[0]));
        int maxYear = lSpans[0][0];

        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.add(lSpans[0][1]);

        for(int i = 1; i < lSpans.length; i++) {
            int minimumDeath = queue.peek();
            int nextBirthday = lSpans[i][0];
            if(nextBirthday < minimumDeath){
                maxYear = lSpans[i][0];
            } else {
                queue.poll();
            }
            queue.add(lSpans[i][1]);
        }
        return maxYear;

    }

}
