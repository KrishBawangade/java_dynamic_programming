package knapsack;


public class KnapsackSpaceOptimized {

    public static void main(String[] args){
        int[] weight = {4,5,3};
        int[] values = {30,50,30};

        int maxWeight = 7;

        int size = values.length;

        int[] dp = new int[maxWeight+1];

        for(int w = weight[0]; w<=maxWeight; w++){
            dp[w] = values[0];
        }

        for(int i=1; i<size; i++){

            for(int w=maxWeight; w>=weight[i]; w--){
                dp[w] = Math.max(dp[w], values[i] + dp[w-weight[i]]);
            }

        }

        System.out.println(dp[maxWeight]);
    }
}
