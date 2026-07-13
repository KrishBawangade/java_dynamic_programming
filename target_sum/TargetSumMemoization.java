package target_sum;

import java.util.*;

public class TargetSumMemoization {

    public static int findTargetSumWays(int[] nums, int[][] dp, int offset, int i, int target) {

        if(target < -offset || target> offset){
            return 0;
        }

        if(i==0){
            int count =0;

            if(target - nums[i] == 0){
                count++;
            }

            if(target + nums[i] == 0){
                count++;
            }

            return count;
        }

        if(dp[i][target+offset] != -1){
            return dp[i][target+offset];
        }

        int positive = findTargetSumWays(nums, dp, offset, i-1, target-nums[i]);

        int negative = findTargetSumWays(nums, dp, offset, i-1, target+nums[i]);

        return dp[i][target+offset] = positive+negative;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,1,1};
        int target = 3;

        int size = nums.length;

        int total = 0;

        for(int i=0; i<size; i++){
            total += Math.abs(nums[i]);
        }

        int[][] dp = new int[size][2*total+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(findTargetSumWays(nums, dp, total, size-1, target));
    }
}
