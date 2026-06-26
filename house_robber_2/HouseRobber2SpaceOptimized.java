package house_robber_2;

import java.util.*;

public class HouseRobber2SpaceOptimized {

    public static int robLinear(int[] nums){
        int prev2 = 0;
        int prev1 = nums[0];

        for(int i=1; i<nums.length; i++){

            int pick = nums[i] + prev2;

            int nonpick = prev1;

            int temp = Math.max(pick, nonpick);

            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};

        if(nums.length == 1){
            System.out.println(nums[0]);
            return;
        }

        int ans1 = robLinear(Arrays.copyOfRange(nums, 0, nums.length-1));
        int ans2 = robLinear(Arrays.copyOfRange(nums, 1, nums.length));

        int max = Math.max(ans1, ans2);

        System.out.println(max);
    } 
}
