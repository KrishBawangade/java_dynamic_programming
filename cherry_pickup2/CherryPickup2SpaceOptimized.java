package cherry_pickup2;

import java.util.Arrays;

public class CherryPickup2SpaceOptimized {
    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] prev = new int[n][n];

        for(int j=0; j<n; j++){
            for(int k=0; k<n; k++){
                if(j == k){
                    prev[j][k] = grid[0][j]; 
                    continue;
                }

                prev[j][k] = grid[0][j] + grid[0][k];
            }
        }

        for(int row=1; row<m; row++){

            int[][] curr = new int[n][n];

            for(int i =0; i<n; i++){
                Arrays.fill(curr[i], Integer.MIN_VALUE);
            }

            for(int col1 = 0; col1<n; col1++){
                for(int col2=0; col2<n; col2++){

                    int max = Integer.MIN_VALUE;

                    for(int i=-1; i<=1; i++){
                        for(int j=-1; j<=1; j++){
                            if( ((col1+i)>=0 && (col2+j)>=0) && ((col1+i)<grid[0].length && (col2+j)<grid[0].length) ){
                                max = Math.max(
                                    max,
                                    prev[col1+i][col2+j]
                                );
                            }
                        }
                    }

                    if(col1 == col2){
                        curr[col1][col2] = grid[row][col1] + max;
                        continue;
                    }

                    curr[col1][col2] = grid[row][col1] + grid[row][col2] + max;
                }
            }

            prev = curr;
        }
        
        int ans = 0;

        for (int col1 = 0; col1 < n; col1++) {
            for (int col2 = 0; col2 < n; col2++) {
                ans = Math.max(ans, prev[col1][col2]);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[][] grid = {{3,1,1}, {2,5,1}, {1,5,5}, {2,1,1}};

        System.out.println(cherryPickup(grid));
    }
}
