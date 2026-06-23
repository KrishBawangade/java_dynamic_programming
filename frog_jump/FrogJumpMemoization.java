package frog_jump;

import java.util.*;

public class FrogJumpMemoization{

    public static int frogJump(int n, int[] heights, int[] dp) {
        if(n-1 == 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int jump1 = frogJump(n-1, heights, dp) + Math.abs(heights[n-1] - heights[n-2]);
        int min = jump1;

        if(n-2>0){
            int jump2 = frogJump(n-2, heights, dp) + Math.abs(heights[n-1] - heights[n-3]);

            min = Math.min(min, jump2);
        }
        
        return dp[n] = min;
    }


    public static void main(String[] args){
        int[] heights = {10,20,30,10};

        int n = 4;

        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);

        System.out.println(frogJump(n, heights, dp));
    }
}