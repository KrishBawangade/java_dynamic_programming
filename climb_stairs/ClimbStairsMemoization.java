package climb_stairs;

import java.util.Arrays;

public class ClimbStairsMemoization {

    public static int climbStairs(int n, int[] dp){
        if(n==0 || n==1){
            return 1;
        }

        if(dp[n] != -1){
            System.out.println("Skip "+ n);
            return dp[n];
        }

        return dp[n] = climbStairs(n-1, dp) + climbStairs(n-2, dp);
    }

    

    public static void main(String[] args){

        int n = 5;

        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);

        System.out.println(climbStairs(n, dp));
    }
}
