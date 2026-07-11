package coin_change;


public class CoinChangeTabulation {

    public static void main(String[] args){
        int[] coins = {1,2,5};

        int amount = 11;

        int size = coins.length;

        int[][] dp = new int[size][amount+1];

        for(int i=0; i<size; i++){
            dp[i][0] = 0;
        }

        for(int j=1; j<=amount; j++){
            if(j%coins[0] == 0){
                dp[0][j] = j/coins[0];
            }else{
                dp[0][j] = -1;
            }
        }        

        for(int i=1; i<size; i++){
            for(int j=1; j<=amount; j++){
                int pick = Integer.MAX_VALUE;
                
                if(coins[i]<=j){
                    int res = dp[i][j-coins[i]];
                    if(res != -1){
                        pick = res+1;
                    }
                }

                int nonPick = dp[i-1][j];

                if(pick == Integer.MAX_VALUE){
                    dp[i][j] = nonPick;
                    continue;
                }

                if(nonPick == -1){
                    dp[i][j] = pick;
                    continue;
                }

                dp[i][j] = Math.min(pick, nonPick);
            }
        }

        System.out.println(dp[size-1][amount]);
    }
}
