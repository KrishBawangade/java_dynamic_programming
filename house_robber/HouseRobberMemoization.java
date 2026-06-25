package house_robber;

import java.util.*;

public class HouseRobberMemoization {

    public static int rob(int[] nums, int[] dp){
        return findMax(nums, dp, nums.length-1);
    }

    private static int findMax(int[] nums, int[] dp, int i){
        if(i<0){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int left = nums[i] + findMax(nums, dp, i-2); // pick
        int right = findMax(nums, dp, i-1); // non-pick 

        return dp[i] = Math.max(left, right);
    }

    public static void main(String[] args){
        int[] nums = {1,3,1,4,5,6,7};

        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);

        System.out.println(rob(nums, dp));
    } 
}
