package frog_jump;

public class FrogJumpTabulation{

    public static void main(String[] args){
        int[] heights = {10,20,30,10};

        int n = 4;

        int[] dp = new int[n+1];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int jump1 = dp[i - 1]
                    + Math.abs(heights[i] - heights[i - 1]);

            int jump2 = Integer.MAX_VALUE;

            if (i > 1) {
                jump2 = dp[i - 2]
                        + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(jump1, jump2);
        }

        System.out.println(dp[n-1]);
    }
}