package min_cost_cut_stick;

import java.util.Arrays;

public class MinCostCutStickMemoization {

    public static int minCost(int[] cuts, int[][] dp, int i, int j) {
        if(i>j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for(int k=i; k<=j; k++){
            int cost = (cuts[j+1] - cuts[i-1]) + minCost(cuts, dp, i, k-1) + minCost(cuts, dp, k+1, j);
            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }

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

        int[][] dp = new int[newCuts.length+1][newCuts.length+1];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(minCost(newCuts, dp, 1, cuts.length));
    }
}
