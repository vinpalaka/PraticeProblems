package intervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomTest {
    MeetingRoom meetingRoom = new MeetingRoom();

    @Test
    void printOverlapped() {
        int ar[][] = { {1, 5}, {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}};
        meetingRoom.printOverlapped(ar);
    }

    @Test
    void setMeetingRoom() {
        Integer ar[][] = { {1, 5}, {3, 7}, {2, 6}, {10, 15}, {12, 20}, {5, 6}, {4, 8}, {4, 100}};
        int max = meetingRoom.minimumRooms(ar);
        assertEquals(max, minMeetingRooms(ar));
        int max2 = meetingRoom.getRoomCount(ar);
        assertEquals(minMeetingRooms(ar), max2 );

    }

    public int minMeetingRooms(Integer[][] ar) {

        Arrays.sort(ar, Comparator.comparingInt(x -> Integer.valueOf(x[0])));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count=1;
        queue.offer(ar[0][1]);

        for(int i=1; i<ar.length; i++){
            if(ar[i][0]<queue.peek()){
                count++;

            }else{
                queue.poll();
            }

            queue.offer(ar[i][1]);
        }

        return count;
    }
}