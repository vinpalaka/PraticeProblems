package recursion;

public class HouseRobber {
    int[] ar;
    public int rob(int[] nums) {
        int len = nums.length;
        ar = nums;
        int maxProfit = findMaxProfit(0, len, 0);
        return maxProfit;
    }

    private int findMaxProfit(int counter, int len, int max) {
        if(counter < len) {
            System.out.println(1 >>> 1);
            int max1 = findMaxProfit(counter + 2, len, max + ar[counter]);
            if(counter + 1 < len ) {
                int max2 =  findMaxProfit(counter + 3, len, ar[counter + 1] + max);
                return Math.max(max1, max2);
            } else {
                return max1;
            }
        }
        return max;
    }

    private int findMaxProfit1(int counter, int len) {
        if(counter < len) {
            int max1 = ar[counter] + findMaxProfit1(counter + 2, len);
            if(counter + 1 < len ) {
                int max2 = ar[counter + 1] + findMaxProfit1(counter + 3, len);
                return Math.max(max1, max2);
            } else {
                return max1;
            }
        }
        return 0;
    }


}
