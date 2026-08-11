package min_cost_cut_stick;

import java.util.Arrays;

public class MinCostCutStickTabulation {

    public static void main(String[] args){
        int[] cuts = {1,3,5,4};
        int n = 7;

        int[] newCuts = new int[cuts.length+2];
        newCuts[0] = 0;
        for(int i=0; i<cuts.length; i++){
            newCuts[i+1] = cuts[i];
        }

        newCuts[cuts.length+1] = n;

        Arrays.sort(newCuts);

        int[][] dp = new int[newCuts.length][newCuts.length];
        
        for(int i=cuts.length; i>=1; i--){
            for(int j=i; j<=cuts.length; j++){

                int min = Integer.MAX_VALUE;

                for(int k=i; k<=j; k++){
                    int cost = (newCuts[j+1] - newCuts[i-1]) + dp[i][k-1] + dp[k+1][j];
                    min = Math.min(min, cost);
                }

                dp[i][j] = min;
            }
        }

        System.out.println(dp[1][cuts.length]);
    }
}
