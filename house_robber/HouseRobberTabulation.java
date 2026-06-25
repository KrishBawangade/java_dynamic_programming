package house_robber;

public class HouseRobberTabulation {

    public static void main(String[] args){
        int[] nums = {1,3,1,4,5,6,7};

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++){

            int pick;

            if(i>1){
                pick = nums[i] + dp[i-2];
            }else{
                pick = nums[i];
            }

            int nonpick = dp[i-1];

            dp[i] = Math.max(pick, nonpick);
        }

        System.out.println(dp[nums.length-1]);
    } 
}
