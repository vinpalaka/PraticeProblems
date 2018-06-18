package strings;

import java.util.ArrayDeque;

/**
 * Doesn't fully work
 */
public class MathExpression {
    public static void main(String[] args) {
        String expression1 = "5+16-((9-6)-(4-2))";
        String expression2 = "22+(2-4)";

        //if char is '(' then pop into stack previous number and isAdd
        //reset prev to 0 then contiue. if i see ')' then i'll pop from stack and eval


        int result = evaluate(expression1);
        System.out.println(result);
    }

    public static int evaluate(String e) {
        //
        int prev = 0;
        boolean isAdd = true;
        int i=0, j = 0;
        ArrayDeque<Integer> nStack = new ArrayDeque<>();
        ArrayDeque<Boolean> oStack = new ArrayDeque<>();

        for(; i < e.length(); i++) {
            char c = e.charAt(i);
            if(c == '(') {
                j = i+1;
                nStack.push(prev);
                oStack.push(isAdd);
                prev = 0;
                isAdd=true;
            }
            if(c == ')') {
                if(isAdd)
                    prev = prev + Integer.valueOf(e.substring(j, i));
                else
                    prev = prev - Integer.valueOf(e.substring(j, i));
                j = i+1;

                isAdd = oStack.pop();
                if(isAdd)
                    prev = prev + nStack.pop();
                else
                    prev = prev - nStack.pop();

            }
            if(c == '+') {

                if(isAdd)
                    prev = prev + Integer.valueOf(e.substring(j, i));
                else
                    prev = prev - Integer.valueOf(e.substring(j, i));
                j = i+1;
                System.out.println("In add" + prev);
                isAdd = true;
            } else if(c == '-') {
                if(isAdd)
                    prev = prev + Integer.valueOf(e.substring(j, i));
                else
                    prev = prev - Integer.valueOf(e.substring(j, i));
                j = i+1;
                System.out.println("In minus" + prev);
                isAdd = false;
            }

        }

        System.out.println("final:" +  e.substring(j, i));

        if(isAdd)
            if(!nStack.isEmpty())
                prev = prev + nStack.pop();
            else
            if(!nStack.isEmpty())
                prev = prev - nStack.pop();
        return prev;

    }
}
