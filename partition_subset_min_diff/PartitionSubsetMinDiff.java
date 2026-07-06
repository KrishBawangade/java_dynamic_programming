package partition_subset_min_diff;

public class PartitionSubsetMinDiff {

    public static int minSubsetDiff(int[] nums){
        int size = nums.length;

        int totalSum = nums[0];

        for(int i=1; i<size; i++){
            totalSum += nums[i];
        }

        int target = totalSum/2;

        boolean[] prev = new boolean [target+1]; 

        prev[0] = true;

        if (nums[0] <= target) {
            prev[nums[0]] = true;
        }

        for(int i=1; i<nums.length; i++){

            boolean[] curr = new boolean[target+1];
            curr[0] = true;
            
            for(int j=1; j<=target; j++){

                boolean pick = false;

                if(j>=nums[i]){
                    pick = prev[j-nums[i]];
                }

                boolean nonpick = prev[j];

                curr[j] = pick || nonpick;
            }

            prev = curr;
        }

        for(int k=target; k>=0; k--){
            if(prev[k]){
                return Math.abs((totalSum - k) - k);
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};

        System.out.println(minSubsetDiff(nums));
    }
}
