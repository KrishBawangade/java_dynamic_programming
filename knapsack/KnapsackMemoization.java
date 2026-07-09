package knapsack;

import java.util.Arrays;

public class KnapsackMemoization {

    public static int knapsack(int[] weight, int[] values, int[][] dp, int n, int maxWeight){
        if(n==0){
            return weight[n]<=maxWeight ? values[n] : 0;
        }

        if(dp[n][maxWeight] != -1){
            return dp[n][maxWeight];
        }

        int pick = 0;

        if(weight[n]<=maxWeight){
            pick = values[n] + knapsack(weight, values, dp, n-1, maxWeight- weight[n]);
        }

        int nonPick = knapsack(weight, values, dp, n-1, maxWeight);

        return dp[n][maxWeight] = Math.max(pick, nonPick);
    }


    public static void main(String[] args){
        int[] weight = {4,5,3};
        int[] values = {30,50,30};

        int maxWeight = 7;

        int size = values.length;

        int[][] dp = new int[size][maxWeight+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(knapsack(weight, values, dp, size-1, maxWeight));
    }
}
