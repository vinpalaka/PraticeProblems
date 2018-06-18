package recursion;

public class RecursionUtil {


    public static int getMinChanges(String x, String y) {

        int min = getMinChanges(x, y, 0);
        return min;

    }

    private static int getMinChanges(String first, String second, int x) {

        if(first.equals(second) || x == first.length() || x == second.length())
            return (second.length() - x) + (first.length() - x);

        if(first.length() == 0) {
            return second.length();
        } else if(second.length() == 0) {
            return first.length();
        } else {

            if(first.charAt(x) == second.charAt(x)){
                //Right
                return getMinChanges(first, second, x+1);
            }
            else {
                //delete
                int deletefirst = 1 + getMinChanges(first.substring(0, x) + first.substring(x + 1, first.length()), second, x);
                int insertfirst = 1 + getMinChanges(first.substring(0, x) + second.charAt(x) +
                        first.substring(x, first.length()), second, x);
                //insert
                if(deletefirst > insertfirst)
                    return insertfirst;
                else
                    return deletefirst;
            }
        }
    }

    /**
     * Checks if the given number is prime or not.
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        if (num % 2 == 0)
            return false;
        else {
            return isPrime(num, 3);
        }
    }


    private static boolean isPrime(int num, int counter) {
        if (counter > Math.sqrt(num)) //we don't need to check anything higher than divisible by 3 if number doesn't go into 3
            return true;
        if (num % counter == 0)
            return false;
        else {
            return isPrime(num, counter + 1);
        }
    }

    public int getSum(int sum, int mSum, int[] ar, int index) {
        if(index == ar.length ){
            return mSum;
        }

        sum = sum + ar[index];
        mSum = Math.max(mSum, sum);
        sum = Math.max(sum, 0);
        return getSum(sum, mSum, ar, index + 1);
    }



}

