package coin_change2;


public class CoinChange2SpaceOptimized{
    public static void main(String[] args){
        int[] coins = {1,2,5};

        int amount = 5;

        int size = coins.length;

        int[] prev = new int[amount+1];

        prev[0] = 1;

        for(int j=1; j<=amount; j++){
            if(j%coins[0] == 0){
               prev[j] = 1;
            }
        }        

        for(int i=1; i<size; i++){

            for(int j=coins[i]; j<=amount; j++){
                
                int pick = prev[j-coins[i]];

                prev[j] += pick;
                
            }
        }

        System.out.println(prev[amount]);
    }
}