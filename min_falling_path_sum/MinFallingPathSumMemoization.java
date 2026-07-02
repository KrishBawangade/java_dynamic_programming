package min_falling_path_sum;

import java.util.Arrays;

public class MinFallingPathSumMemoization{

    public static int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int pathSum = minFallingPath(matrix, dp, m-1, i);
            min = Math.min(min, pathSum);
        }

        return min;
    }

    private static int minFallingPath(int[][] matrix, int[][] dp, int m, int n){
        if(m == 0){
            return matrix[m][n];
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int diagLeft = Integer.MAX_VALUE;
        int diagRight = Integer.MAX_VALUE;

        if(n>0){
            diagLeft = minFallingPath(matrix, dp, m-1, n-1);
        }

        if(n<matrix[m].length-1){
            diagRight = minFallingPath(matrix, dp, m-1, n+1);
        }

        int min = Math.min(diagLeft, diagRight);

        int down = minFallingPath(matrix, dp, m-1, n);

        min = Math.min(min, down);

        return dp[m][n] = matrix[m][n] + min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3}, {6,5,4}, {7,8,9}};

        System.out.println(minFallingPathSum(matrix));
    }
}