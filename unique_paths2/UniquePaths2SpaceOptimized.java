package unique_paths2;

public class UniquePaths2SpaceOptimized {
    public static void main(String[] args){
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};

        int m = obstacleGrid.length;
        int n= obstacleGrid[0].length;

        int[] prev = new int[n];

        prev[0] = 1;

        for(int i=0; i<m; i++){

            int[] curr = new int [n];
            
            for(int j = 0; j<n; j++){

                if(obstacleGrid[i][j] == 1){
                    curr[j] = 0;
                    continue;
                }

                if(i == 0 && j==0){
                    curr[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;


                if(i>0){
                    up = prev[j]; 
                }

                if(j>0){
                    left = curr[j-1];
                }

                curr[j] = up+left;
            }

            prev = curr;
        }

        System.out.println(prev[n-1]);
    }
}
