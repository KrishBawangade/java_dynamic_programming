package subset_sum_equals_k;

public class SubsetSumEqualsKMemoization{

    public static boolean subsetSum(int[] nums, int k) {

        Boolean dp[][] = new Boolean[nums.length][k+1]; 

        return checkSubsetSum(nums, dp, k, nums.length-1);
    }

    private static boolean checkSubsetSum(int[] nums, Boolean[][] dp, int k, int i){

        if(k==0){
            return true;
        }

        if(i==0){
            return nums[i] == k;
        }

        if(dp[i][k] != null){
            return dp[i][k];
        }

        boolean pick = false;
        boolean nonpick = false;

        if(k>=nums[i]){
            pick = checkSubsetSum(nums, dp, k-nums[i], i-1);
        }

        if(!pick){
            nonpick = checkSubsetSum(nums, dp, k, i-1);
        }

        // return true from pick or nonpick else false
        return dp[i][k] = pick || nonpick; 
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        int k = 3;

        System.out.println(subsetSum(nums, k));
    }
}