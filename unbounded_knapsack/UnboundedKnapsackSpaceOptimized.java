package unbounded_knapsack;

public class UnboundedKnapsackSpaceOptimized {
    public static void main(String[] args){
        int[] weight = {2,4,6};
        int[] values = {5,11,13};

        int maxWeight = 10;

        int size = values.length;

        int[] dp = new int[maxWeight+1];

        for(int w = weight[0]; w<=maxWeight; w++){
            dp[w] = values[0];
        }

        for(int i=1; i<size; i++){

            for(int w=weight[i]; w<=maxWeight; w++){
                dp[w] = Math.max(dp[w], values[i] + dp[w-weight[i]]);
            }

        }

        System.out.println(dp[maxWeight]);
    }
}
