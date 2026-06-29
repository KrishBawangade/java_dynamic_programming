package unique_paths2;

import java.util.Arrays;

public class UniquePaths2Memoization{

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return uniquePaths(obstacleGrid, dp, m-1, n-1);
        
    }

    private static int uniquePaths(int[][] obstacleGrid, int[][] dp, int m, int n) {

        if(obstacleGrid[m][n] == 1){
            return 0;
        }

        if(m == 0 && n == 0){
            return 1;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int up= 0;
        int left = 0;

        if(m>0){
            up = uniquePaths(obstacleGrid, dp, m-1, n); 
        }

        if(n>0){
            left = uniquePaths(obstacleGrid, dp, m, n-1); 
        }

        return dp[m][n] = up+left;
    }

    public static void main(String[] args){

        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}