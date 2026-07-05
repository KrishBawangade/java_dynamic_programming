package partition_equal_subset_sum;

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int size = nums.length;

        int totalSum = nums[0];
        
        for(int i=1; i<size; i++){
            totalSum+=nums[i];
        }

        if(totalSum % 2 != 0){
            return false;
        }

        return subsetSum(nums, totalSum/2);
    }

    public static boolean subsetSum(int[] nums, int k) {

        boolean[] prev = new boolean [k+1]; 

        prev[0] = true;

        if (nums[0] <= k) {
            prev[nums[0]] = true;
        }

        
        for(int i=1; i<nums.length; i++){

            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            
            for(int j=1; j<=k; j++){

                boolean pick = false;

                if(j>=nums[i]){
                    pick = prev[j-nums[i]];
                }

                boolean nonpick = prev[j];

                curr[j] = pick || nonpick;
            }

            prev = curr;
        }

        return prev[k];
    }

    public static void main(String[] args){
        int[] nums = {1,5,11,5};

        System.out.println(canPartition(nums));
    }
}
