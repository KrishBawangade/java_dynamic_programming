package coin_change;

import java.util.Arrays;

public class CoinChangeMemoization {

    public static int coinChange(int[] coins, int[][] dp, int n, int amount) {

        if(amount == 0){
            return 0;
        }

        if(n==0){

            if(amount%coins[n] == 0){
                return amount/coins[n];
            }

            return -1;
        }

        if(dp[n][amount] != -2){
            return dp[n][amount];
        }

        int pick = Integer.MAX_VALUE;

        if(coins[n] <= amount){
            int res = coinChange(coins, dp, n, amount-coins[n]);

            if(res!=-1){
                pick = res+1;
            }
        }  

        int nonPick = coinChange(coins, dp, n-1, amount);

        if(pick == Integer.MAX_VALUE){
            return dp[n][amount] = nonPick;
        }

        if(nonPick == -1){
            return dp[n][amount] = pick;
        }

        return dp[n][amount] = Math.min(pick, nonPick);
    }

    public static void main(String[] args){
        int[] coins = {2,4,6};

        int amount = 11;

        int size = coins.length;

        int[][] dp = new int[size][amount+1];

        for(int[] row: dp){
            Arrays.fill(row, -2);
        }

        System.out.println(coinChange(coins, dp, size-1, amount));
    }
}
