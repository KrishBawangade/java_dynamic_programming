package coin_change2;

public class CoinChange2Tabulation{
    public static void main(String[] args){
        int[] coins = {1,2,5};

        int amount = 5;

        int size = coins.length;

        int[][] dp = new int[size][amount+1];

        for(int i=0; i<size; i++){
            dp[i][0] = 1;
        }

        for(int j=1; j<=amount; j++){
            if(j%coins[0] == 0){
                dp[0][j] = 1;
            }
        }        

        for(int i=1; i<size; i++){
            for(int j=1; j<=amount; j++){
                int pick = 0;
                
                if(coins[i]<=j){
                    pick = dp[i][j-coins[i]];
                }

                int nonPick = dp[i-1][j];

                dp[i][j] = pick + nonPick;
            }
        }

        System.out.println(dp[size-1][amount]);
    }
}