package recursion;

import java.util.ArrayList;
import java.util.List;

public class Paranthesis {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        getParenthesis("", n, 0, 0);
        return list;
    }

    private void getParenthesis(String s, int n, int open, int close) {

            if(s.length() == n * 2) {
                list.add(s);
                return;
            }
            if(n > open) {
                getParenthesis( s + "(", n, open + 1, close);
            }
            if(open > close) {
                getParenthesis( s + ")" , n, open, close + 1);
            }
    }
}
