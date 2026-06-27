package ninja_training;

import java.util.*;

public class NinjaTrainingMemoization{

    public static int ninjaTraining(int[][] points){
        int max = Integer.MIN_VALUE;

        int n = points.length;

        int[][] dp = new int[n][3];
        
        // filling the arrays with -1
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }


        for(int j=0; j<3; j++){
            int meritPoints = train(points, dp, n-1, j);
            max = Math.max(max, meritPoints);
        }

        return max;
    }

    public static int train(int[][] points, int[][] dp, int i, int j){
        if(i==0){
            return points[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;

        for(int k = 0; k<3; k++){
            if(k==j){
                continue;
            }

            int meritPoints = points[i][j] + train(points, dp, i-1, k);

            max = Math.max(max, meritPoints);
        }

        return dp[i][j] = max;
    }

    public static void main(String[] args){
        int[][] points = {{1,2,5}, {3,1,1}, {3,3,3}};

        System.out.println(ninjaTraining(points));
    }
}