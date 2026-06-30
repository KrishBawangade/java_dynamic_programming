package minimum_path_sum;

import java.util.Arrays;

public class MinimumPathSumMemoization {
    public static int minPathSum( int[][] grid, int[][] dp, int m, int n) {
        if(m == 0 && n == 0){
            return grid[m][n];
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int up= Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if(m>0){
            up = grid[m][n] + minPathSum(grid, dp, m-1, n); 
        }

        if(n>0){
            left = grid[m][n] + minPathSum(grid, dp, m, n-1); 
        }

        return dp[m][n] = Math.min(up, left);
    }

    public static void main(String[] args){

        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        int m = grid.length;
        int n= grid[0].length;

        int[][] dp = new int[m][n];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(minPathSum(grid, dp, m-1, n-1));
    }
}
