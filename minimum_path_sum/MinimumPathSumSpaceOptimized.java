package minimum_path_sum;

public class MinimumPathSumSpaceOptimized {
    public static void main(String[] args){

        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        int m = grid.length;
        int n= grid[0].length;

        int[] prev = new int[n];

        prev[0] = grid[0][0];

        for(int i=0; i<m; i++){

            int[] curr = new int [n];
            
            for(int j = 0; j<n; j++){

                if(i == 0 && j==0){
                    curr[j] = grid[i][j];
                    continue;
                }

                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;


                if(i>0){
                    up = grid[i][j]+ prev[j]; 
                }

                if(j>0){
                    left = grid[i][j] + curr[j-1];
                }

                curr[j] = Math.min(up, left);
            }

            prev = curr;
        }

        System.out.println(prev[n-1]);
    }
}
