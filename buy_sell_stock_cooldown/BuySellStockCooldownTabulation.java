package buy_sell_stock_cooldown;

public class BuySellStockCooldownTabulation {
    public static void main(String[] args){
        int[] prices= {1,2,3,0,2};

        int size = prices.length;

        int[][][] dp = new int[size+1][2][2];

        for(int i=size-1; i>=0; i--){
            
            dp[i][1][1] = dp[i+1][1][0];
            
            dp[i][1][0] = Math.max(
                -prices[i] + dp[i+1][0][0], 
                dp[i+1][1][0]
            );
                   
            dp[i][0][0] = Math.max(
                prices[i] + dp[i+1][1][1],
                dp[i+1][0][0]
            );

        }

        System.out.println(dp[0][1][0]);
    } 
}
