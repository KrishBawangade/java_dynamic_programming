package unbounded_knapsack;

import java.util.Arrays;

public class UnboundedKnapsackMemoization {
    public static int knapsack(int[] weight, int[] values, int[][] dp, int n, int maxWeight){
        if(n==0){
            return weight[n]<=maxWeight ? values[n] : 0;
        }

        if(dp[n][maxWeight] != -1){
            return dp[n][maxWeight];
        }

        int pick = 0;

        if(weight[n]<=maxWeight){
            pick = values[n] + knapsack(weight, values, dp, n, maxWeight- weight[n]);
        }

        int nonPick = knapsack(weight, values, dp, n-1, maxWeight);

        return dp[n][maxWeight] = Math.max(pick, nonPick);
    }


    public static void main(String[] args){
        int[] weight = {2,4,6};
        int[] values = {5,11,13};

        int maxWeight = 10;

        int size = values.length;

        int[][] dp = new int[size][maxWeight+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(knapsack(weight, values, dp, size-1, maxWeight));
    }
}
