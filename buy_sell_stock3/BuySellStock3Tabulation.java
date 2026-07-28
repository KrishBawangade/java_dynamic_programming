package buy_sell_stock3;

public class BuySellStock3Tabulation{
    public static void main(String[] args){
        int[] prices= {3,3,5,0,0,3,1,4};

        int size = prices.length;

        int[][][] dp = new int[size+1][2][3];

        // for i reaching size
        for(int b=0; b<2; b++){
            for(int c=0; c<3; c++){
                dp[size][b][c] = 0;
            }
        }

        // for cap= 0
        for(int i=0; i<=size; i++){
            for(int b=0; b<2; b++){
                dp[i][b][0] = 0;
            }
        }

        for(int i=size-1; i>=0; i--){
            for(int b=1; b>=0; b--){

                for(int c=2; c>=1; c--){
                    if(b == 1){
                        dp[i][b][c] = Math.max(
                            -prices[i] + dp[i+1][0][c], 
                            dp[i+1][1][c]
                        );
                    }else{
                        dp[i][b][c] = Math.max(
                            prices[i] + dp[i+1][1][c-1],
                            dp[i+1][0][c]
                        );
                    }
                }

            }
        }

        System.out.println(dp[0][1][2]);
    } 
}