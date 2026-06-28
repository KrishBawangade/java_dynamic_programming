package unique_paths;

import java.util.*;

public class UniquePathsMemoization {

    public static int uniquePaths(int[][] dp, int m, int n) {
        if(m == 1 && n == 1){
            return 1;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int down= 0;
        int right = 0;

        if(m>1){
            down = uniquePaths(dp, m-1, n); 
        }

        if(n>1){
            right = uniquePaths(dp, m, n-1); 
        }

        return dp[m][n] = down+right;
    }

    public static void main(String[] args){

        int m = 3;
        int n= 7;

        int[][] dp = new int[m+1][n+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(uniquePaths(dp, m, n));
    }
}
