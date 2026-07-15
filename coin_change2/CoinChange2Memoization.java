package coin_change2;

import java.util.Arrays;

public class CoinChange2Memoization{

    public static int change(int[] coins, int[][] dp, int n, int amount) {

        if(amount == 0){
            return 1;
        }

        if(n==0){

            if(amount%coins[n] == 0){
                return 1;
            }

            return 0;
        }

        if(dp[n][amount] != -1){
            return dp[n][amount];
        }

        int pick = 0;

        if(coins[n] <= amount){
            pick = change(coins, dp, n, amount-coins[n]);
        }  

        int nonPick = change(coins, dp, n-1, amount);

        return dp[n][amount] = pick+nonPick;
    }

    public static void main(String[] args){
        int[] coins = {1,2,5};

        int amount = 5;

        int size = coins.length;

        int[][] dp = new int[size][amount+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(change(coins, dp, size-1, amount));
    }
}