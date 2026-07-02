package min_falling_path_sum;

public class MinFallingPathSumTabulation {
    public static int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];

        for(int j=0; j<n; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<m; i++){

            for(int j=0; j<n; j++){

                int diagLeft = Integer.MAX_VALUE;
                int diagRight = Integer.MAX_VALUE;

                if(j>0){
                    diagLeft = minFallingPath(matrix, dp, i-1, j-1);
                }

                if(j<n-1){
                    diagRight = minFallingPath(matrix, dp, i-1, j+1);
                }

                int innerMin = Math.min(diagLeft, diagRight);

                int down = minFallingPath(matrix, dp, i-1, j);

                innerMin = Math.min(innerMin, down);

                dp[i][j] = matrix[i][j] + innerMin;
            }

        }

        int min = dp[m-1][0];

        for(int j=1; j<n; j++){
            min = Math.min(min, dp[m-1][j]);
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3}, {6,5,4}, {7,8,9}};

        System.out.println(minFallingPathSum(matrix));
    }
}
