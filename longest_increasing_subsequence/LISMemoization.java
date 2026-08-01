package longest_increasing_subsequence;

import java.util.Arrays;

public class LISMemoization{

    public static int lengthOfLIS(int[] nums, int[][] dp, int i, int prevIndex) {
        if(i == nums.length){
            return 0;
        }

        if(dp[i][prevIndex+1]!= -1){
            return dp[i][prevIndex+1];
        }

        int pick = 0;

        if(prevIndex == -1 || nums[i]>nums[prevIndex]){
            pick = 1+ lengthOfLIS(nums, dp, i+1, i);
        }

        int nonPick = lengthOfLIS(nums, dp, i+1, prevIndex);

        return dp[i][prevIndex+1] = Math.max(pick, nonPick);
    }

    public static void main(String[] args){
        int[] nums = {10,9,-1,5,3,7,101,18};

        int size = nums.length;

        int[][] dp = new int[size][size+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(lengthOfLIS(nums, dp, 0, -1));
    }
}