package count_partitions_with_diff;

public class CountPartitionsWithDiff {

    public static void main(String[] args){
        int[] nums = {1,1,2,3};
        int size = nums.length;

        int d = 1;

        int totalSum = nums[0];

        for(int i=1; i<size; i++){
            totalSum+=nums[i];
        }

        if(totalSum-d<0 || (totalSum-d)%2 == 1){
            System.out.println(0);
            return;
        }

        int k = (totalSum-d)/2;

        int[] prev = new int[k+1];

        if(nums[0] == 0){
            prev[0] = 2;
        }else{
            prev[0] = 1;

            if(nums[0]<=k){
                prev[nums[0]] = 1; 
            }
        }

        for(int i=1; i<size; i++){
            int[] curr = new int[k+1];

            for(int j=0; j<=k; j++){
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
