package frog_jump_k_distance;

public class FrogJumpKSpaceOptimized {
    public static void main(String[] args){
        int[] heights = {10,20,30,10};

        int n = 4;
        int k=2;

        int[] buffer = new int[k];
        buffer[0] = 0; // dp[0]

        for (int i = 1; i < n; i++) {
            int minCost = Integer.MAX_VALUE;

            for (int jump = 1; jump <= k; jump++) {
                if (i - jump >= 0) {

                    int prevDp = buffer[(i - jump) % k]; 

                    int cost = prevDp
                            + Math.abs(heights[i] - heights[i - jump]);

                    minCost = Math.min(minCost, cost);
                }
            }

            buffer[i % k] = minCost; // storing the states in circular buffer
        }

        System.out.println(buffer[(n - 1) % k]);
    }
}
