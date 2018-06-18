package math;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MathCheckUtils {
    /**
     * does (x1 + y1, y1) (x1, y1 +x1) can possibly equal (x2, y2)
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public String checkSum(int x1, int y1, int x2, int y2) {
        if (!isValid(x1, y1, x2, y2)) {
            return "No";
        } else {
            //This is where I check
            LinkedList<Point> queue = new LinkedList();
            queue.add(new Point(x1, y1));

            while (!queue.isEmpty()) {
                Point item = queue.remove();
                System.out.println(item);
                int newX = item.x + item.y;
                if (isValid(newX, item.y, x2, y2)) {
                    queue.add(new Point(newX, item.y));
                }
                int newY = item.x + item.y;
                if (isValid(item.x, newY, x2, y2)) {
                    queue.add(new Point(item.x, newY));
                }
                if (item.x == x2 && item.y == y2) {
                    return "Yes";
                }
            }
            return "No";
        }
    }

    /**
     * Given string of 0, 1, and ?
     * write all possible combinations of string
     * where ? can be either 0 or 1
     *
     * @param test
     */
    public void getCombinations(String test) {
        getAllStringInput(0, test, test.length());
    }

    private String getAllStringInput(int i, String test, int length) {
        if (i == length) {
            System.out.println(test);
            return test;
        }
        char c = test.charAt(i);
        if (c == '?') {
            getAllStringInput(i + 1, test.substring(0, i) + "0" + test.substring(i + 1, length), length);
            getAllStringInput(i + 1, test.substring(0, i) + "1" + test.substring(i + 1, length), length);
        } else {
            test = getAllStringInput(i + 1, test, length);
        }
        return test;
    }

    private class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private boolean isValid(int x1, int y1, int x2, int y2) {//1,6,4,8
        return (x1 <= x2 && y1 <= y2) ||
                (x1 == x2 && (x1 + y1) <= y2) ||
                (y1 == y2 && (x1 + y1 <= x2));
    }

    /**
     * See how many permutations of a exists in b
     * @param a
     * @param b
     * @return
     */
    public int getPerm(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();

        //Puts all characters of a and value is how many times it appears
        for (int i = 0; i < a.length(); i++) {
            map.merge(a.charAt(i), 1, (old, newC) -> old + newC);
        }
        int countW = 0;
        int size = b.length() - (a.length() - 1);
        for (int j = 0; j < size; j++) {
            if (map.containsKey(b.charAt(j))) {
                Map<Character, Integer> dup = (Map<Character, Integer>) ((HashMap<Character, Integer>) map).clone();
                countW += getPermExists(j, j + a.length(), b, dup);
            }
        }

        return countW;
    }

    /**
     * Remove all characters found in b
     * @param j
     * @param size
     * @param b
     * @param dup
     * @return if map is empty at the end, then we know that it is a valid permutaion.
     */
    private int getPermExists(int j, int size, String b, Map<Character, Integer> dup) {
        for (; j < size; j++) {
            if (dup.containsKey(b.charAt(j))) {
                int v = dup.compute(b.charAt(j), (x, y) -> y - 1);
                if (v == 0) {//when we've found all matching charactrs, remove from map
                    dup.remove(b.charAt(j));
                }
            } else {
                return 0;
            }
        }
        return dup.size() == 0 ? 1 : 0;
    }

    /**
     * Prints all the prime numbers upto n
     * @param n
     */
    public static String getAllPrime(int n) {
        String primes = "";
        if (n > 0) {
            primes += "2";
            for (int i = 3; i <= n; i = i + 2) { //Can skip all numbers divible by 2
                Boolean isPrime = true;
                for (int j = 3; j <= Math.sqrt(i); j = j + 2) { //since we are skipping 2, no need to check
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime)
                    primes += ", " + i;
            }
        }
        return primes;
    }
}
