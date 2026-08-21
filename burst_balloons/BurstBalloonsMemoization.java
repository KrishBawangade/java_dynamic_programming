package burst_balloons;

import java.util.Arrays;

public class BurstBalloonsMemoization {

    public static int maxCoins(int[] nums, int[][] dp, int i, int j) {

        if(i>j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++){

            int coins = nums[i-1] * nums[k] * nums[j+1] + maxCoins(nums, dp, i, k-1) + maxCoins(nums, dp, k+1, j);
            max = Math.max(max, coins);
        }
        return dp[i][j] = max;
    }

    public static void main(String[] args){
        int[] nums = {3,1,5,8};
        int size = nums.length;

        int[] numsUpdated = new int[size+2];

        for(int i=0; i<size; i++){
            numsUpdated[i+1] = nums[i]; 
        }

        numsUpdated[0] = 1;
        numsUpdated[size+1] = 1;

        int[][] dp = new int[size+2][size+2];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(maxCoins(numsUpdated, dp, 1, size));
    }
}
