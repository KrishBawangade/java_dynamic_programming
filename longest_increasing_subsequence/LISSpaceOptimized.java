package longest_increasing_subsequence;

public class LISSpaceOptimized {
    public static void main(String[] args){
        int[] nums = {10,9,-1,5,3,7,101,18};

        int size = nums.length;

        int[] ahead = new int[size+1];

        for(int i=size-1; i>=0; i--){

            int[] curr = new int[size+1]; 

            for(int p=i; p>=0; p--){

                int prevIndex = p-1;

                int pick = 0;

                if(prevIndex == -1 || nums[i]>nums[prevIndex]){
                    pick = 1+ ahead[i+1];
                }

                int nonPick = ahead[p];

                curr[p] = Math.max(pick, nonPick);
            }

            ahead = curr;
        }

        System.out.println(ahead[0]);
    }
}
