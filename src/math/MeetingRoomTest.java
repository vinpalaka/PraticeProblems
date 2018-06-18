package math;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomTest {

    @Test
    void fileMinMeetingRooms() {
        MeetingRoom s = new MeetingRoom();
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{1,4});
        list.add(new Integer[]{3,9});
        list.add(new Integer[]{8,9});
        list.add(new Integer[]{2,6});
        list.add(new Integer[]{7,10});
        list.add(new Integer[]{5,10});

        int m = s.fileMinMeetingRooms(list);

        int v = s.fileMinMeetingRoomsPq(list);
        System.out.println(m);
        System.out.println(v);
    }
}