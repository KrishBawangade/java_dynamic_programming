package unique_paths;

public class UniquePathsSpaceOptimized {

    public static void main(String[] args){

        int m = 3;
        int n= 7;

        int[] prev = new int[n+1];

        prev[1] = 1;

        for(int i=1; i<=m; i++){

            int[] curr = new int [n+1];
            
            for(int j = 1; j<=n; j++){

                if(i == 1 && j==1){
                    curr[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;


                if(i>1){
                    up = prev[j]; 
                }

                if(j>1){
                    left = curr[j-1];
                }

                curr[j] = up+left;
            }

            prev = curr;
        }

        System.out.println(prev[n]);
    }
}
