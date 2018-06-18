package intervals;

import java.util.*;

public class MeetingRoom {

    /**
     * Print all the meetings that are conflicting.
     * @param ar
     */
    public void printOverlapped(int[][] ar) {
        Arrays.sort(ar, Comparator.comparingInt(x -> Integer.valueOf(x[0])));
        for (int i = 0; i < ar.length; i++) {
            int end = ar[i][1];
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[j][0] < end) {
                    System.out.println("[" + ar[i][0] + ", " + end + "]" + "and [" + ar[j][0] + ", " + ar[j][1] + "]");
                } else
                    break;
            }
            System.out.println();
        }
    }

    /**
     * Finds the minumum number of meeting rooms needed
     * https://www.programcreek.com/2014/05/leetcode-meeting-rooms-ii-java/
     * @param ar meeting start times and end times [1 2] [3 5]
     * @return
     */
    public int minimumRooms(Integer[][] ar) {
        if(ar.length == 1) {
            return 1;
        }
        int max = 1;
        Arrays.sort(ar, Comparator.comparingInt(x -> Integer.valueOf(x[0])));
        int count = 1;//track consecutive meeting overlap
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(ar[0][1]);
        for(int i = 1; i < ar.length; i++) {
            Integer oldestMeeting = queue.peek();
            int startOfNextMeeting = ar[i][0];
            if( oldestMeeting > startOfNextMeeting ) {
                count++;
                max = Math.max(count, max);
            } else {
                queue.poll();
                count--;
            }
            queue.add(ar[i][1]);
        }
        return max;
    }

    /**
     * Even better way to do meeting room problem
     */
    public int getRoomCount(Integer[][] ar) {

        Integer max = Arrays.stream(ar)
                .max(Comparator.comparingInt(x->x[0])).get()[0];
        Integer min = Arrays.stream(ar)
                .min(Comparator.comparingInt(x->x[0])).get()[0];
        int[] roomCount = new int[max-min+1];
        for(int i=0; i < ar.length; i++) {
            int start = ar[i][0];
            int end = ar[i][1];
            roomCount[start - min] += 1;
            roomCount[end - min] -= 1;
        }
        max = 0;
        int count = 0;
        for(int room : roomCount) {
            count +=room;
            max = Math.max(count, max);
        }
        return max;
    }
}
