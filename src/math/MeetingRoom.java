package math;

import java.util.*;

public class MeetingRoom {

    public int fileMinMeetingRooms(List<Integer[]> s){
        List<Integer> sor = new ArrayList<>();

        for(Integer[] i : s) {
            sor.add(i[0]);
            sor.add(-i[1]);
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)){
                    return o1 - o2;
                }else{
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        };

        System.out.println(sor);
        Collections.sort(sor, comparator);
        System.out.println(sor);

        int max = 0;
        int counter = 0;
        for(int i = 0; i < sor.size(); i++){
            if(sor.get(i) > 0){
                counter++;
            }else{
                counter--;
            }
            max = Math.max(max, counter);
        }

        return max;
    }


    public int fileMinMeetingRoomsPq(List<Integer[]> list) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Collections.sort(list, Comparator.comparingInt(x->x[0]));
        q.add(list.get(0)[1]);
        int counter = 1;
        for(int i = 1; i < list.size(); i++) {
            int v = q.peek();
            if(list.get(i)[0] < q.peek()) {
                counter++;
            } else {
                q.poll();
            }
            q.add(list.get(i)[1]);
        }
        return counter;
    }
}
