package cherry_pickup2;

import java.util.*;

public class CherryPickup2Memoization{

    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maxCherry(grid, dp, m-1, 0, n-1);
    }

    private static int maxCherry(int[][] grid, int[][][] dp, int row, int col1, int col2){

        if(row == 0){

            if(col1 == col2){
                return grid[row][col1];
            }

            return grid[row][col1] + grid[row][col2];
        }

        if(dp[row][col1][col2] != -1){
            return dp[row][col1][col2];
        }

        int max = Integer.MIN_VALUE;

        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if( ((col1+i)>=0 && (col2+j)>=0) && ((col1+i)<grid[0].length && (col2+j)<grid[0].length) ){
                    max = Math.max(
                        max,
                        maxCherry(grid, dp, row-1, col1+i, col2+j)
                    );
                }
            }
        }

        if(col1 == col2){
            return dp[row][col1][col2] = grid[row][col1] + max;
        }

        return dp[row][col1][col2] = grid[row][col1] + grid[row][col2] + max;
    } 

    public static void main(String[] args){
        int[][] grid = {{3,1,1}, {2,5,1}, {1,5,5}, {2,1,1}};

        System.out.println(cherryPickup(grid));
    }
}