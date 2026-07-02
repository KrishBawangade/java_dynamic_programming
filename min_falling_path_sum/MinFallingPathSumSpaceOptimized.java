package min_falling_path_sum;

public class MinFallingPathSumSpaceOptimized {
    public static int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] prev = new int[n];

        for(int j=0; j<n; j++){
            prev[j] = matrix[0][j];
        }

        for(int i=1; i<m; i++){
            int[] curr = new int[n];

            for(int j=0; j<n; j++){

                int best = prev[j];

                if(j>0){
                    best = Math.min(best, prev[j-1]);
                }

                if(j<n-1){
                    best = Math.min(best, prev[j+1]);
                }

                curr[j] = matrix[i][j] + best;
            }
            
            prev = curr;
        }

        int min = prev[0];

        for(int j=1; j<n; j++){
            min = Math.min(min, prev[j]);
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3}, {6,5,4}, {7,8,9}};

        System.out.println(minFallingPathSum(matrix));
    }
}
