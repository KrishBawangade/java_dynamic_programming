package coin_change;

public class CoinChangeSpaceOptimized {
    public static void main(String[] args){
        int[] coins = {1,2,5};

        int amount = 11;

        int size = coins.length;

        int[] prev = new int[amount+1];

        prev[0] = 0;

        for(int j=1; j<=amount; j++){
            if(j%coins[0] == 0){
               prev[j] = j/coins[0];
            }else{
                prev[j] = -1;
            }
        }        

        for(int i=1; i<size; i++){

            for(int j=coins[i]; j<=amount; j++){
                if(prev[j- coins[i]] != -1){
                    int pick = prev[j-coins[i]] + 1;

                    if(prev[j] == -1){
                        prev[j] = pick;
                    }else{
                        prev[j] = Math.min(prev[j], pick);
                    }
                }

                
            }
        }

        System.out.println(prev[amount]);
    }
}
