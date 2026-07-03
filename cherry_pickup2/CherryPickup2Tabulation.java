package cherry_pickup2;

import java.util.Arrays;

public class CherryPickup2Tabulation {
    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for (int row = 0; row < m; row++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[row][j], Integer.MIN_VALUE);
            }
        }

        dp[0][0][n-1] = grid[0][0] + grid[0][n-1];

        for(int row=1; row<m; row++){
            
            for(int col1 = 0; col1<n; col1++){
                for(int col2=0; col2<n; col2++){

                    int max = Integer.MIN_VALUE;

                    for(int i=-1; i<=1; i++){
                        for(int j=-1; j<=1; j++){
                            if( ((col1+i)>=0 && (col2+j)>=0) && ((col1+i)<grid[0].length && (col2+j)<grid[0].length) ){
                                max = Math.max(
                                    max,
                                    dp[row-1][col1+i][col2+j]
                                );
                            }
                        }
                    }

                    if(col1 == col2){
                        dp[row][col1][col2] = grid[row][col1] + max;
                        continue;
                    }

                    dp[row][col1][col2] = grid[row][col1] + grid[row][col2] + max;
                }
            }
        }
        
        int ans = Integer.MIN_VALUE;

        for (int col1 = 0; col1 < n; col1++) {
            for (int col2 = 0; col2 < n; col2++) {
                ans = Math.max(ans, dp[m-1][col1][col2]);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[][] grid = {{3,1,1}, {2,5,1}, {1,5,5}, {2,1,1}};

        System.out.println(cherryPickup(grid));
    }
}
