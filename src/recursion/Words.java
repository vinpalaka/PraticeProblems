package recursion;


import java.util.*;


/**
 * Given a word not split. Check if can be a actual word
 * ex helloworld!
 */
public class Words {

        public static List<String> splitnow(String text, Set<String> dict) {
            //Go thru text and find substring that works
            //start in the beginning and start checking at 1;
            //if loop finds a word, call split recursively on rest of it.
            //if text is at the end, then we found word for all and return new arrayList
            //if we go thru loop and reach end, we know we didn't find so return null
            if(text.length() == 0)
                return new ArrayList<>();
            for(int i = 1; i <= text.length(); i++) {
                String word = text.substring(0, i);
                if(dict.contains(word)) {
                    List<String> words = splitnow(text.substring(i, text.length()), dict);
                    if(words != null) {
                        words.add(word);
                        return words;
                    }
                }
            }
            return null;
        }


    }


