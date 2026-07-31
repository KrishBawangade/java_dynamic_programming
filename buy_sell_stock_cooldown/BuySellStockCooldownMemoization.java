package buy_sell_stock_cooldown;

import java.util.Arrays;

public class BuySellStockCooldownMemoization{
    public static int maxProfit(int[] prices, int[][][] dp, int i, int buy, int cooldown) {
        if(i == prices.length){
            return 0;
        }        

        if(dp[i][buy][cooldown] != -1){
            return dp[i][buy][cooldown];
        }

        int profit = 0;

        if(cooldown>0){
            return dp[i][buy][cooldown] = maxProfit(prices, dp, i+1, 1, cooldown-1);
        }

        if(buy == 1){
            int take = -prices[i] + maxProfit(prices, dp, i+1, 0, 0);
            int skip = maxProfit(prices, dp, i+1, 1, 0);

            profit = Math.max(profit, Math.max(take, skip));
        }else{
            int sell = prices[i] + maxProfit(prices, dp, i+1, 1, 1);
            int hold = maxProfit(prices, dp, i+1, 0, 0);

            profit = Math.max(profit, Math.max(sell, hold));
        }

        return dp[i][buy][cooldown] = profit;
    }

    public static void main(String[] args){
        int[] prices= {1,2,3,0,2};

        int size = prices.length;

        int[][][] dp = new int[size][2][2];

        for(int[][] matrix: dp){
            for(int[] row: matrix){
                Arrays.fill(row, -1);
            }
        }

        System.out.println(maxProfit(prices, dp, 0, 1, 0));
    } 
}