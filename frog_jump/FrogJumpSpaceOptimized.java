package frog_jump;

public class FrogJumpSpaceOptimized{

    public static void main(String[] args){
        int[] heights = {10,20,30,10};

        int n = 4;

        int prev2 = 0;
        int prev1 = 0;

        for (int i = 1; i < n; i++) {
            int jump1 = prev1 +
                    Math.abs(heights[i] - heights[i - 1]);

            int jump2 = Integer.MAX_VALUE;

            if (i > 1) {
                jump2 = prev2 +
                        Math.abs(heights[i] - heights[i - 2]);
            }

            int curr = Math.min(jump1, jump2);

            prev2 = prev1;
            prev1 = curr;
        }

        System.out.println(prev1);
    }
}