package strings;

public class EditDistance {

    /**
     * Basically check check till we find a character that is unequal.
     * Then check the rest of them are equal, if it is, then in one edit
     * the whole string should be equal.
     * @param s
     * @param t
     * @return
     */
    public static boolean isOneEditDistance(String s, String t) {
        if(s.length( ) == 0 && t.length()== 0)
            return false;
        if(s.equals(t)) {
            return false;
        }
        boolean sameLength = s.length() == t.length();
        boolean sIsBigger = s.length() > t.length();
        for(int i = 0; i < Math.min(s.length(), t.length());  i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(sameLength) {
                    return s.substring(i + 1).equals(t.substring(i+1));
                } else if(sIsBigger) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
