package math;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum {
    public static int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }

    /**
     * Uses memoization
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for(int s : nums)
            sum+=s;
        int[][] memo = new int[nums.length][2 * sum + 1];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, S, memo, sum);
    }
    public int calculate(int[] nums, int i, int sum, int S, int[][] memo, int t) {
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            if (memo[i][sum + t] != Integer.MIN_VALUE) {
                return memo[i][sum + t];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo, t);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo, t);
            memo[i][sum + t] = add + subtract;
            return memo[i][sum + t];
        }
    }
}
