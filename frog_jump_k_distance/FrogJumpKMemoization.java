package frog_jump_k_distance;

import java.util.*;

public class FrogJumpKMemoization{

    public static int frogJump(int n, int[] heights, int k, int[] dp) {
        if(n == 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int min = Integer.MAX_VALUE;

        for(int i=1; i<=k; i++){
            if(n>(i-1)){
                int jumpk = frogJump(n-i, heights, k, dp) + Math.abs(heights[n] - heights[n-i]);
                min = Math.min(min, jumpk);
            }
        }
        
        return dp[n] = min;
    }


    public static void main(String[] args){
        int[] heights = {10,20,30,10};

        int n = 4;
        int k=2;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        System.out.println(frogJump(n-1, heights, k, dp));
    }
}