package house_robber_2;

import java.util.*;

public class HouseRobber2Memoization {

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
        int[] nums = {1,2,3,1};

        if(nums.length == 1){
            System.out.println(nums[0]);
            return;
        }

        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);

        int ans1 = rob(Arrays.copyOfRange(nums, 0, nums.length-1), dp);
        Arrays.fill(dp, -1);
        int ans2 = rob(Arrays.copyOfRange(nums, 1, nums.length), dp);

        int max = Math.max(ans1, ans2);

        System.out.println(max);
    } 
}
