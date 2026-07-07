package count_subsets_sum_k;

import java.util.*;

public class CountSubsetsSumKMemoization {

    private static int countSubsets(int[] nums, int[][] dp, int k, int i){
        if(k == 0){
            return 1;
        }

        if(i==0){
            return k == nums[i] ? 1 : 0;
        }

        if(dp[i][k] != -1){
            return dp[i][k];
        }

        int pick = 0;

        if(nums[i] <= k){
            pick = countSubsets(nums, dp, k-nums[i], i-1);
        }

        int nonPick = countSubsets(nums, dp, k, i-1);

        return dp[i][k] = pick + nonPick;
    }

    public static void main(String [] args){
        int[] nums = {1,2,2,3};
        int size = nums.length;

        int k = 3;

        int[][] dp = new int[size][k+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(countSubsets(nums, dp, k, size-1));
    } 
}
