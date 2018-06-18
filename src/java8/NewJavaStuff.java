package java8;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewJavaStuff {
    public void trySynchronized() {
        List<Integer> source = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> fish = new CopyOnWriteArrayList<>(source);
        List<Integer> mammals = Collections.synchronizedList(source);
        Set<Integer> birds = new ConcurrentSkipListSet<>();
        birds.addAll(source);


        synchronized (mammals) {
            for (Integer f : fish)
                fish.add(4); // c1
            for (Integer m : mammals)
                mammals.add(4);
            for (Integer b : birds)
                birds.add(5);
            System.out.println( fish.size() +" "+ mammals.size() +" "+ birds.size());
            HashSet<String> s;

        }
    }

    /**
     * This will take in a list of names and return a map with the count of names using stream.
     * Uses merge to keep adding.
     * @param names
     */
    public Map<String, Integer> addNamesToMapWithCount(List<String> names) {
        Map<String, Integer> map = names.stream()
                .collect(Collectors.toMap(String::toString, (x) -> 1, (y, z) -> y + z));
        map.merge("Vin", 1, (x, y) -> x + y); //Adds a key that's already in map
        map.merge("George", 1, (x, y) -> x + y);//Adds a key that's not already there
        map.merge("Vin", 3, (x, y) -> x + 1); //Could Corrupt data and add 3 to count but controlling by not adding new value but 1

        return map;
    }

    public int findSum(int[] ar) {
        return Arrays.stream(ar).sum();

    }

    public void plusMinu(int[] ar) {
        IntStream y = Arrays.stream(ar).flatMap(x -> IntStream.of(x));
        System.out.println(y);
    }

    public void removeDuplicates(int[] ar) {
        List<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(4);
        s.add(1);
        s.add(4);
        s.add(5);
        s.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(s.get(3));
        s = s.stream().map(x -> x = 0).collect(Collectors.toList());

        System.out.println(s.get(3));



    }

    public void minMax(int[] arr) {
        int size = arr.length;
        int currMin = arr[0], currMax=arr[0], minF=arr[0], maxF = arr[0];
        for(int i =1; i < 4; i++) {
            minF+=arr[i];
            if(currMax < arr[i]) {
                currMax = arr[i];
            }
            if(currMin > arr[i]) {
                currMin = arr[i];
            }
        }
        minF = minF;
        maxF = minF;

        for(int i = 1; i < size; i++) {
            int numToCheck = arr[i + 3];
            if( minF - currMax > minF - numToCheck) {
                minF = minF - currMax + numToCheck;
                for(int j =i - 3; j < i; j++) {
                    if(currMax < arr[j]) {
                        currMax = arr[j];
                    }
                }
            }
            if(maxF - currMin < maxF - numToCheck) {
                maxF = maxF - currMin + numToCheck;
                for(int j =i - 3; j < i; j++) {
                    if(currMin > arr[j]) {
                        currMin = arr[j];
                    }
                }
            }
        }
        System.out.println(minF + " " + maxF);


    }

    public String timeConversion(String s) {
        String[] vals = s.split(":");
        if(vals[2].contains("PM")) {
            String first = vals[0];
            if(!"12".equals(first)){
                int value = Integer.valueOf(first) + 12;
                vals[0] = ""+value;
            }

            vals[2] = vals[2].substring(0, vals[2].indexOf("P"));
            return String.join(":", vals);
        } else {
            if("12".equals(vals[0])) {
                vals[0] = "00";
            }
            vals[2] = vals[2].substring(0, vals[2].indexOf("A"));
            return String.join(":", vals);
        }

    }

    public Map<String, Double> testToMap(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(Animal::toString, Animal::getWeight, (x, y) -> x + y));
    }



    public Optional<Integer> findTriplet(int[] ar) {
        int first, second, third;
        if(ar[0] > ar[1]) {
            second = ar[0];
            first = ar[1];
        } else {
            second = ar[1];
            first = ar[0];
        }
        if(ar[2] > second) {
            third = ar[2];
        } else {
            third = second;
            if(ar[2] > first) {
                second = ar[2];

            } else {
               second = first;
               first = ar[2];
            }
        }

        for(int i = 3; i < ar.length; i++) {
            if(ar[i] > third) {
                first = second;
                second = third;
                third = ar[i];
            } else if(ar[i] > second) {
                first = second;
                second = ar[i];
            } else if(ar[i] > first) {
                first = ar[i];
            }
        }
        return Optional.of(first + second + third);
    }

    //https://www.quora.com/Given-a-list-of-integers-how-do-you-find-the-largest-sum-of-any-contiguous-subsequence
    public Optional<Integer> largestSubseqSum(int[] arr) {
        int sum = arr[0];
        int fSum = sum;
        int start = 0;
        int end = 0;
        for(int i = 1; i < arr.length; i++) {
            if(sum <= 0) {
                sum = 0;
                start = i;
            }
            sum+= arr[i];
            if(sum > fSum) {
                fSum = sum;
                end = i;
            }
        }
        System.out.println("Start: " + start + " end: " + end);
        return Optional.of(fSum);
    }

    public void convertStringToHashSet(String checkString) {
        String s = "yolo";
        String[] mds = s.split("");
        Map<String, Integer> map = Arrays.stream(checkString.split(""))
                .collect(Collectors.toMap(String::toString, y -> 1, (x, y)-> x+y ));
        System.out.println(map);
    }

    public void setVerticesToZero(int[][] adjMatrix) {


    }


}
