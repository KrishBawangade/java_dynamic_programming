package subset_sum_equals_k;

public class SubsetSumEqualsKTabulation {
    public static boolean subsetSum(int[] nums, int k) {

        boolean dp[][] = new boolean[nums.length][k+1]; 

        for(int i=0; i<nums.length; i++){
            dp[i][0] = true;
        }

        if (nums[0] <= k) {
            dp[0][nums[0]] = true;
        }

        
        for(int i=1; i<nums.length; i++){
            
            for(int j=1; j<=k; j++){

                boolean pick = false;

                if(j>=nums[i]){
                    pick = dp[i-1][j-nums[i]];
                }

                boolean nonpick = dp[i-1][j];

                dp[i][j] = pick || nonpick;
            }
        }

        return dp[nums.length-1][k];
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        int k = 3;

        System.out.println(subsetSum(nums, k));
    }
}
