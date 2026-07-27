package buy_sell_stock2;

import java.util.Arrays;

public class BuySellStock2Memoization {
    public static int maxProfit(int[] prices, int[][] dp, int i, int buy) {
        if(i == prices.length){
            return 0;
        }        

        if(dp[i][buy] != -1){
            return dp[i][buy];
        }

        int profit = 0;

        if(buy == 1){
            int take = -prices[i] + maxProfit(prices, dp, i+1, 0);
            int skip = maxProfit(prices, dp, i+1, 1);

            profit = Math.max(profit, Math.max(take, skip));
        }else{
            int sell = prices[i] + maxProfit(prices, dp, i+1, 1);
            int hold = maxProfit(prices, dp, i+1, 0);

            profit = Math.max(profit, Math.max(sell, hold));
        }

        return dp[i][buy] = profit;
    }

    public static void main(String[] args){
        int[] prices= {1,2,3,4,5};

        int size = prices.length;

        int[][] dp = new int[size][2];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(maxProfit(prices, dp, 0, 1));
    } 
}
