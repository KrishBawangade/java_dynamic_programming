package frog_jump_k_distance;

public class FrogJumpKTabulation{

    public static void main(String[] args){
        int[] heights = {10,20,30,10};

        int n = 4;
        int k=2;

        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for(int j=1; j<=k; j++){
                if(i>(j-1)){
                    int jumpk = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
                    min = Math.min(min, jumpk);
                }
            }

            dp[i] = min;
        }

        System.out.println(dp[n-1]);
    }
}