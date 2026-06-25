package house_robber;

public class HouseRobberSpaceOptimized {
    public static void main(String[] args){
        int[] nums = {1,3,1,4,5,6,7};

        int prev2 = 0;
        int prev1 = nums[0];

        for(int i=1; i<nums.length; i++){

            int pick = nums[i] + prev2;

            int nonpick = prev1;

            int temp = Math.max(pick, nonpick);

            prev2 = prev1;
            prev1 = temp;
        }

        System.out.println(prev1);
    } 
}
