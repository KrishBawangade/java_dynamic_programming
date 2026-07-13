package target_sum;


public class TargetSumTabulation {

    public static void main(String[] args){
        int[] nums = {1,1,1,1,1};
        int target = 3;

        int size = nums.length;

        int total = 0;

        for(int i=0; i<size; i++){
            total += Math.abs(nums[i]);
        }

        if(target < -total || target> total){
            System.out.println(0);
            return;
        }

        int[][] dp = new int[size][2*total+1];

        for(int t=-total; t<=total; t++){
            int count = 0;
            if(t-nums[0] == 0){
                count++;
            }

            if(t + nums[0] == 0){
                count++;
            }

            dp[0][t+total] = count;
        }

        for(int i=1; i<size; i++){
            for(int t=-total; t<=total; t++){

                int positive = 0;
                int negative = 0;

                if(t-nums[i]>=-total){
                    positive = dp[i-1][t-nums[i]+total];
                }

                if(t+nums[i]<=total){
                    negative = dp[i-1][t+nums[i]+total];
                }

                dp[i][t+total] = positive+negative;
            }
        }

        
        System.out.println(dp[size-1][target+total]);
    }
}
