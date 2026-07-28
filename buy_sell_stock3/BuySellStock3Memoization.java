package buy_sell_stock3;

import java.util.Arrays;

public class BuySellStock3Memoization{
    public static int maxProfit(int[] prices, int[][][] dp, int i, int buy, int cap) {
        if(i == prices.length || cap == 0){
            return 0;
        }        

        if(dp[i][buy][cap] != -1){
            return dp[i][buy][cap];
        }

        int profit = 0;

        if(buy == 1){
            int take = -prices[i] + maxProfit(prices, dp, i+1, 0, cap);
            int skip = maxProfit(prices, dp, i+1, 1, cap);

            profit = Math.max(profit, Math.max(take, skip));
        }else{
            int sell = prices[i] + maxProfit(prices, dp, i+1, 1, cap-1);
            int hold = maxProfit(prices, dp, i+1, 0, cap);

            profit = Math.max(profit, Math.max(sell, hold));
        }

        return dp[i][buy][cap] = profit;
    }

    public static void main(String[] args){
        int[] prices= {3,3,5,0,0,3,1,4};

        int size = prices.length;

        int[][][] dp = new int[size][2][3];

        for(int[][] matrix: dp){
            for(int[] row: matrix){
                Arrays.fill(row, -1);
            }
        }

        System.out.println(maxProfit(prices, dp, 0, 1, 2));
    }
}