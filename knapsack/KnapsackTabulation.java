package knapsack;

public class KnapsackTabulation {

    public static void main(String[] args){
        int[] weight = {4,5,3};
        int[] values = {30,50,30};

        int maxWeight = 7;

        int size = values.length;

        int[][] dp = new int[size][maxWeight+1];

        for(int w = weight[0]; w<=maxWeight; w++){
            dp[0][w] = values[0];
        }

        for(int i=1; i<size; i++){
            for(int w=0; w<=maxWeight; w++){
                int pick = 0;

                if(weight[i] <= w){
                    pick = values[i] + dp[i-1][w-weight[i]];
                }

                int nonPick = dp[i-1][w];

                dp[i][w] = Math.max(pick, nonPick);
            }
        }

        System.out.println(dp[size-1][maxWeight]);
    }
}
