package intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BirthYear {

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
