package java8;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NewJavaStuffTest {
    NewJavaStuff javaStuff = new NewJavaStuff();

    @Test
    void trySynchronized() {
        javaStuff.trySynchronized();
    }

    @Test
    void testFindSUm() {
        int[] ar = {1,3,4,5};
        int sum = javaStuff.findSum(ar);

        System.out.println(sum);
    }

    @Test
    public void testaddNamesToMapWithCount() {
        Map<String, Integer> map = javaStuff.addNamesToMapWithCount(Arrays.asList("Vin", "Nancy", "Victor", "Vin", "Vin", "vin", "Nancy", "Tim"));
        System.out.println(map);
    }

    @Test
    void testPlusMinus() {
        int[] ar = {-4, 3, -9, 0, 4, 1};
        javaStuff.plusMinu(ar);
    }

    @Test
    void testMinMax() {
        int[] ar = {1, 2, 3, 4, 5};
        javaStuff.minMax(ar);
    }

    @Test
    void testTimeConversion() {
        String v = "12:20:00AM";
        String m = javaStuff.timeConversion(v);
        System.out.println(m);
        v = "07:05:01AM";
        m = javaStuff.timeConversion(v);
        System.out.println(m);
        v = "07:05:01PM";
        m = javaStuff.timeConversion(v);
        System.out.println(m);
        v = "01:05:01AM";
        m = javaStuff.timeConversion(v);
        System.out.println(m);
        v = "01:05:01PM";
        m = javaStuff.timeConversion(v);
        System.out.println(m);
    }


    @Test
    public void testToMap() {
        Animal an = new Animal("Vin", true, 1001.1);
        Animal an2 = new Animal("Vivian", true, 1001.1);
        Animal an4 = new Animal("Victor", false, 5001.1);
        Animal an5 = new Animal("Vivian", true, 1001.1);


        List<Animal> animals = new ArrayList<>();
        List<String> tokens = new ArrayList<>(Arrays.asList("1", "2", "3"));
        String value = String.join(",", tokens);
        animals.add(an);
        animals.add(an2);
        animals.add(an4);
        animals.add(an5);
        Herd e = new Herd(animals);
        List<Herd> herd = new ArrayList<>();
        herd.add(e);
        System.out.println(javaStuff.testToMap(animals));

    }

    @Test
    public void testFindTriplet() {
        int[] ar = new int[] {12, 3, 4, 1, 6, 9};
        javaStuff.findTriplet(ar).ifPresent(System.out::println);

    }

    @Test
    public void testlargestSubseqSum() {
        int[] ar = new int[] {12, 3, -15, 1, 6, 9};
        javaStuff.largestSubseqSum(ar).ifPresent(System.out::println);
        ar = new int[] {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
        javaStuff.largestSubseqSum(ar).ifPresent(System.out::println);

        ar = new int[] {-11, -3, -5, -4, -6, -14, -2, -7, -13, -3};
        javaStuff.largestSubseqSum(ar).ifPresent(System.out::println);

    }

    @Test
    public void testConvertString() {
        javaStuff.convertStringToHashSet("appplee");

    }

    @Test
    public void testRemoveDup() {
        int []ar = new int[] {-11, -3, -5, -4, -6, -14, -2, -7, -13, -3};
        javaStuff.removeDuplicates(ar);
    }

    @Test
    public void testMatrix() {
        int[][] j = new int[10][10];
        javaStuff.setVerticesToZero(j);
    }
}