package count_subsets_sum_k;

public class CountSubsetsSumKSpaceOptimized {
    
    public static void main(String [] args){
        int[] nums = {1,2,2,3};
        int size = nums.length;

        int k = 3;

        int[] prev = new int[k+1];

        prev[0] = 1;

        if(nums[0]<=k){
            prev[nums[0]] = 1; 
        }

        for(int i=1; i<size; i++){
            int[] curr = new int[k+1];
            curr[0] = 1;

            for(int j=1; j<=k; j++){
                int pick = 0;

                if(nums[i] <= j){
                    pick = prev[j-nums[i]];
                }

                int nonPick = prev[j];

                curr[j] = pick + nonPick;
            }

            prev = curr;
        }

        System.out.println(prev[k]);
    } 
}
