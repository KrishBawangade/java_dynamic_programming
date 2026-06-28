package unique_paths;

public class UniquePathsTabulation {
    
    public static void main(String[] args){

        int m = 3;
        int n= 7;

        int[][] dp = new int[m+1][n+1];

        dp[1][1] = 1;

        for(int i=1; i<=m; i++){
            for(int j = 1; j<=n; j++){

                if(i == 1 && j==1){
                    continue;
                }

                int up = 0;
                int left = 0;


                if(i>1){
                    up = dp[i-1][j]; 
                }

                if(j>1){
                    left = dp[i][j-1];
                }

                dp[i][j] = up+left;
            }
        }

        System.out.println(dp[m][n]);
    }
}
