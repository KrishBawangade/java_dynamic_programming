package buy_sell_stock2;


public class BuySellStock2Tabulation {

    public static void main(String[] args){
        int[] prices= {1,2,3,4,5};

        int size = prices.length;

        int[][] dp = new int[size+1][2];

        dp[size][0] = 0;
        dp[size][1] = 0;

        for(int i=size-1; i>=0; i--){
            for(int b=1; b>=0; b--){

                if(b == 1){
                    dp[i][b] = Math.max(
                        -prices[i] + dp[i+1][0], 
                        dp[i+1][1]
                    );
                }else{
                    dp[i][b] = Math.max(
                        prices[i] + dp[i+1][1],
                        dp[i+1][0]
                    );
                }

            }
        }

        System.out.println(dp[0][1]);
    } 
}
