package longest_increasing_subsequence;

public class LISTabulation {

    public static void main(String[] args){
        int[] nums = {10,9,-1,5,3,7,101,18};

        int size = nums.length;

        int[][] dp = new int[size+1][size+1];

        for(int i=size-1; i>=0; i--){
            for(int p=i; p>=0; p--){

                int prevIndex = p-1;

                int pick = 0;

                if(prevIndex == -1 || nums[i]>nums[prevIndex]){
                    pick = 1+ dp[i+1][i+1];
                }

                int nonPick = dp[i+1][p];

                dp[i][p] = Math.max(pick, nonPick);
            }
        }

        System.out.println(dp[0][0]);
    }
}
