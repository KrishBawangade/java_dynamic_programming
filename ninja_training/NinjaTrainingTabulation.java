package ninja_training;

public class NinjaTrainingTabulation{

    public static int ninjaTraining(int[][] points){

        int n = points.length;

        int[][] dp = new int[n][3];
        
        for(int j=0; j<3; j++){
            dp[0][j] = points[0][j];
        }

        for(int i=1; i<n; i++){

            for(int j=0; j<3; j++){
                
                int innerMax = Integer.MIN_VALUE;

                for(int k = 0; k<3; k++){
                    if(k==j){
                        continue;
                    }
    
                    int meritPoints = points[i][j] + dp[i-1][k];
                    innerMax = Math.max(innerMax, meritPoints);
                }

                dp[i][j] = innerMax;
            }


        }

        int lastMax = dp[n-1][0];

        for(int i=1; i<3; i++){
            lastMax = Math.max(lastMax, dp[n-1][i]);
        }

        return lastMax;
    }

    public static void main(String[] args){
        int[][] points = {{1,2,5}, {3,1,1}, {3,3,3}};

        System.out.println(ninjaTraining(points));
    }
}