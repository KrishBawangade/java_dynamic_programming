package unbounded_knapsack;

public class UnboundedKnapsackTabulation {
    public static void main(String[] args){
        int[] weight = {2,4,6};
        int[] values = {5,11,13};

        int maxWeight = 10;

        int size = values.length;

        int[][] dp = new int[size][maxWeight+1];

        for(int w = weight[0]; w<=maxWeight; w++){
            dp[0][w] = values[0];
        }

        for(int i=1; i<size; i++){
            for(int w=0; w<=maxWeight; w++){
                int pick = 0;

                if(weight[i] <= w){
                    pick = values[i] + dp[i][w-weight[i]];
                }

                int nonPick = dp[i-1][w];

                dp[i][w] = Math.max(pick, nonPick);
            }
        }

        System.out.println(dp[size-1][maxWeight]);
    }
}
