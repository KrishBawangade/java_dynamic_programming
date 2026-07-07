package count_subsets_sum_k;

public class CountSubsetsSumKTabulation {

    public static void main(String [] args){
        int[] nums = {1,2,2,3};
        int size = nums.length;

        int k = 3;

        int[][] dp = new int[size][k+1];

        for(int i=0; i<size; i++){
            dp[i][0] = 1;
        }

        if(nums[0]<=k){
            dp[0][nums[0]] = 1; 
        }

        for(int i=1; i<size; i++){
            for(int j=1; j<=k; j++){
                int pick = 0;

                if(nums[i] <= j){
                    pick = dp[i-1][j-nums[i]];
                }

                int nonPick = dp[i-1][j];

                dp[i][j] = pick + nonPick;
            }
        }

        System.out.println(dp[size-1][k]);
    } 
}
