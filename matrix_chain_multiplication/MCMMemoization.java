package matrix_chain_multiplication;

import java.util.Arrays;

public class MCMMemoization {

    public static int minSteps(int[] arr, int[][] dp, int i, int j){
        if(i==j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        // partitions
        for(int k=i; k<j; k++){
            int steps = arr[i-1]*arr[k]*arr[j] + minSteps(arr, dp, i, k) + minSteps(arr, dp, k+1, j); 
            min = Math.min(min, steps);
        }

        return dp[i][j] = min;
    }

    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        int size = arr.length;

        int[][] dp = new int[size][size];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(minSteps(arr, dp, 1, size-1));
    }
}
