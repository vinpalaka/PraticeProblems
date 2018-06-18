package strings;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        int i  = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while(i < j) {
            if(!Character.isLetter(s.charAt(i))) {
                i++;
            }
            if(!Character.isLetter(s.charAt(j))) {
                j--;
            }
            char n = s.charAt(i);
            char m = s.charAt(j);
            if(i < j && s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
