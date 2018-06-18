package strings;

import java.util.*;
import java.util.stream.Collectors;

public class StringCheckUtils {

    protected class LargestWord {
        private String word;
        private int count;

        LargestWord(String word, int count) {
            this.count = count;
            this.word = word;
        }

        public String getWord() {
            return word;
        }

        public int getCount() {
            return count;
        }
    }

    protected LargestWord findDuplicateWords(String jazz) {

        LargestWord word = null;
        if (jazz != null) {
            String[] splitWords = jazz.split(" ");
            int count = 0;
            String largestWord = null;
            HashMap<String, Integer> words = new HashMap();
            for (String curr : splitWords) {
                if (words.containsKey(curr)) {
                    int i = words.get(curr);
                    words.put(curr, ++i);
                    if (i > count) {
                        count = i;
                        largestWord = curr;
                    }
                } else {
                    words.put(curr, 1);
                }
            }
            if (largestWord != null) {
                word = new LargestWord(largestWord, count);
            }
        }
        return word;
    }



    protected int findCount(String word, char c) {
        int count = word.split("" + c).length;
        return count - 1;
    }

    /**
     * check if any 2 numbers in input add up to sum
     * @param input
     * @param sum
     */
    protected void findThePairs(int[] input, int sum) {
        HashSet<Integer> values = new HashSet<>();
        for (int i : input) {
            values.add(i);
        }
        for (int i : input) {
            int diff = sum - i;
            values.remove(i);
            if (values.contains(sum - i)) {
                System.out.println(i + ", " + diff);
            }
            values.add(i);
        }
    }

    public int getScore(List<String> words) {
        int mScore = 0, i = 1;
        for (String word : words) {
            Set<Character> curr = word.chars().mapToObj(c -> (char) c)
                    .collect(Collectors.toSet());
            int mCurLen = 0;

            for (int j = i; j < words.size(); j++) {
                String currWord = words.get(j);
                boolean isEligible = true;
                if (currWord.length() > mCurLen) {
                    for (int m = 0; m < currWord.length(); m++) {
                        if (curr.contains(currWord.charAt(m))) {
                            isEligible = false;
                            break;
                        }
                    }
                    if (isEligible) {
                        int score = word.length() * currWord.length();
                        if (mScore < score) {
                            mScore = score;
                            mCurLen = currWord.length();
                        }
                    }
                }
            }
            i++;
        }
        return mScore;
    }

    public int[] climbingLadder(int[] scores, int[] alices) {
        //keep track of rank
        int rank = Arrays.stream(scores).mapToObj(x -> (int) x).collect(Collectors.toSet()).size() + 1;

        //keep track of ranks to print
        int ranks[] = new int[alices.length];

        //loop through alice and figure out where each alice rank belongs
        //100 100 50 40 40 20 10
        //5 25 50 120
        //compare with each score iterating down and once you find the number and start there.
        int startScore = scores.length - 1;
        boolean keepSettingScores = false;
        for (int i = 0; i < alices.length; i++) {
            int alice = alices[i];
            for (int j = startScore; j >= 0; j--) {
                if (alice < scores[j]) {
                    ranks[i] = rank;
                    startScore = j;
                    break;
                } else {
                    if (i < alices.length - 1 && alice == alices[i + 1])
                        continue;
                    if (alice != scores[j]) {
                        rank--;
                    }
                }
                if (j == 0 && i < alices.length) {
                    keepSettingScores = true;
                }
            }

        }

        if (keepSettingScores) {
            for (int i = 0; i < ranks.length; i++) {
                if (ranks[i] == 0) {
                    ranks[i] = 1;
                }
            }
        }
        return ranks;

    }

    /**
     * Adds asterisk between all characters in string
     *
     * @param input
     * @return
     */
    public String addAsterisk(String input) {
        input = addAsterisk(1, input);
        return input;
    }

    private String addAsterisk(int i, String input) {
        if (i >= input.length()) {
            return input;
        } else {
            input = input.substring(0, i) + "*" + input.substring(i, input.length());
            return addAsterisk(i + 2, input);
        }
    }

    /**
     * See how many passes there are.
     * @param T names, ones that end with digit are whole group and letters are parts of group
     * @param R only "OK" can be counted as a pass
     * @return number of group passes * 100 over the total number of groups
     */
    public int solution(String[] T, String[] R) {
        // write your code in Java SE 8
        //We don't need to parse every Test name. Start by finding the first OK.
        //If the last character in test name is a number, we can add one to numOfSucc
        //if last character is an a or number, then increment total number
        //score = numOfSucc * 100 / total number

        int total = 0, score = 0, numOfSucc = 0;
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < R.length; i++) {
            String testName = T[i];
            String testResult = R[i];
            boolean testIsOk = "OK".equals(testResult);
            char last = testName.charAt(testName.length() - 1);
            boolean isSingleGroup = Character.isDigit(last);
            if (isSingleGroup) {
                if(testIsOk)
                    numOfSucc++;
                total++;
            } else {
                //groups
                String group = testName.substring(0, testName.length() - 1);
                if (map.containsKey(group)) {
                    if (map.get(group)) {
                        map.put(group, false);
                    }
                } else {
                    if (testIsOk) {
                        map.put(group, testIsOk);
                        numOfSucc++;
                    } else {
                        map.put(group, false);
                    }
                    total++;

                }
            }
        }
        return (numOfSucc * 100) / total;
    }







}
