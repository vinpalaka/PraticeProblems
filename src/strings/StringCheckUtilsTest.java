package strings;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class StringCheckUtilsTest {

    public StringCheckUtilsTest() {

    }
    StringCheckUtils utils = new StringCheckUtils();
    @Test
    public void testFindDuplicateWords() {
        StringCheckUtils.LargestWord value = utils.findDuplicateWords("tomorrow word yolo word one two");
        assertEquals("word", value.getWord());
        assertEquals(2, value.getCount());
        value = utils.findDuplicateWords("tomorrow word yolo word one two two one three one");
        assertEquals("one", value.getWord());
        assertEquals(3, value.getCount());
        value = utils.findDuplicateWords("");
        assertNull(value);
    }

    @Test
    public void testFindCount() {
        assertEquals(2, utils.findCount("apple", 'p'));
        assertEquals(4, utils.findCount("two one okinowa", 'o'));
        int replacement = 41;
        while(replacement++ % 5 != 0 );
        System.out.println(replacement);
        List<Integer> s = null;
        Comparator<Integer> q = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        Collections.sort(s,q);
    }

    @Test
    public void testFindSums() {
        utils.findThePairs(new int[] {4, 6, 5, -10, 8, 5, 20}, 10);
System.out.println();
        utils.findThePairs(new int[] {4, -5, 9, 11, 25, 13, 12, 8}, 20);
        System.out.println();

        utils.findThePairs(new int[] {12, 13, 40, 15, 8, 10, -15}, 25);
        System.out.println();

        utils.findThePairs(new int[] {12, 23, 125, 41, -75, 38, 27, 11, 25}, 50);
    }


    @Test
    public void testCodingChallenge() {
    }

    @Test
    public void testGetScore() {
        String[] ms = {"red", "cat", "kitten", "purple", "frog", "applj"};
        List<String> s = new ArrayList<>(Arrays.asList(ms));
        System.out.println(utils.getScore(s));

    }


    //Example test:    (['test1a', 'test2', 'test1b', 'test1c', 'test3'], ['Wrong answer', 'OK', 'Runtime error', 'OK', 'Time limit exceeded'])
    //WRONG ANSWER  (got 0 expected 33)
    //
    //Example test:    (['codility1', 'codility3', 'codility2', 'codility4b', 'codility4a'], ['Wrong answer', 'OK', 'OK', 'Time limit exceeded', 'OK'])
    //WRONG ANSWER  (got 0 expected 50)

    @Test
    public void testResultScores() {
        String[] names = {"test1a", "test2", "test1b", "test1c", "test3"};
        String[] result = {"Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"};
        int ans = utils.solution(names, result);
        System.out.println(ans);
        String[] names2 = {"codility1", "codility3", "codility2", "codility4b", "codility4a"};
        String[] result2 = {"Wrong answer", "OK", "OK", "Time limit exceeded", "OK"};
        int ans2 = utils.solution(names2, result2);
        String s = Integer.toBinaryString(1041);
        s = "0100";
        int i = -1;
        while(s.charAt(++i) != '0');

        System.out.println(s);
        System.out.println(i);
        System.out.println(ans2);
    }
    @Test
    public void testClimbingLadder() {
        int scores[] = new int[] {100, 100, 50, 40, 40, 20, 10};
        int alices[] = new int[] {5, 25, 50, 120 };

       scores = Arrays.stream("295 294 291 287 287 285 285 284 283 279 277 274 274 271 270 268 268 268 264 260 259 258 257 255 252 250 244 241 240 237 236 236 231 227 227 227 226 225 224 223 216 212 200 197 196 194 193 189 188 187 183 182 178 177 173 171 169 165 143 140 137 135 133 130 130 130 128 127 122 120 116 114 113 109 106 103 99 92 85 81 69 68 63 63 63 61 57 51 47 46 38 30 28 25 22 15 14 12 6 4".split(" "))
        .mapToInt(Integer::parseInt)
                .toArray();
        alices = Arrays.stream("5 5 6 14 19 20 23 25 29 29 30 30 32 37 38 38 38 41 41 44 45 45 47 59 59 62 63 65 67 69 70 72 72 76 79 82 83 90 91 92 93 98 98 100 100 102 103 105 106 107 109 112 115 118 118 121 122 122 123 125 125 125 127 128 131 131 133 134 139 140 141 143 144 144 144 144 147 150 152 155 156 160 164 164 165 165 166 168 169 170 171 172 173 174 174 180 184 187 187 188 194 197 197 197 198 201 202 202 207 208 211 212 212 214 217 219 219 220 220 223 225 227 228 229 229 233 235 235 236 242 242 245 246 252 253 253 257 257 260 261 266 266 268 269 271 271 275 276 281 282 283 284 285 287 289 289 295 296 298 300 300 301 304 306 308 309 310 316 318 318 324 326 329 329 329 330 330 332 337 337 341 341 349 351 351 354 356 357 366 369 377 379 380 382 391 391 394 396 396 400".split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(utils.climbingLadder(scores, alices)).forEach(System.out::println);

    }

    @Test
    public void testAsterisk() {
        String word = "t o morr o w";
        word = utils.addAsterisk(word);
        System.out.println(word);
        word = word.replace(" ", "");
        System.out.println(word);
    }

    @Test
    public void testSubstringCount() {
        String a = "cdabcdabyfdgdfgsdfab";
        String b = "ab";
        int s = (a.length() - a.replace("ab", "").length()) / b.length();
        System.out.println(s);

        System.out.println(a.split(b, -1).length -1);
    }




}