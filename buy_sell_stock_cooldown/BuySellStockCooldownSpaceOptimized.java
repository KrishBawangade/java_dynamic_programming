package buy_sell_stock_cooldown;

public class BuySellStockCooldownSpaceOptimized {
    public static void main(String[] args){
        int[] prices= {1,2,3,0,2};

        int size = prices.length;

        int[][] ahead = new int[2][2];

        for(int i=size-1; i>=0; i--){

            int[][] curr = new int[2][2];
            
            curr[1][1] = ahead[1][0];
            
            curr[1][0] = Math.max(
                -prices[i] + ahead[0][0], 
                ahead[1][0]
            );
                   
            curr[0][0] = Math.max(
                prices[i] + ahead[1][1],
                ahead[0][0]
            );

            ahead = curr;

        }

        System.out.println(ahead[1][0]);
    } 
}
