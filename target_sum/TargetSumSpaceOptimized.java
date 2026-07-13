package target_sum;

public class TargetSumSpaceOptimized {
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

        int[] prev = new int[2*total+1];

        for(int t=-total; t<=total; t++){
            int count = 0;
            if(t-nums[0] == 0){
                count++;
            }

            if(t + nums[0] == 0){
                count++;
            }

            prev[t+total] = count;
        }

        for(int i=1; i<size; i++){

            int[] curr = new int[2*total+1];

            for(int t=-total; t<=total; t++){

                int positive = 0;
                int negative = 0;

                if(t-nums[i]>=-total){
                    positive = prev[t-nums[i]+total];
                }

                if(t+nums[i]<=total){
                    negative = prev[t+nums[i]+total];
                }

                curr[t+total] = positive+negative;
            }
            prev= curr;
        }

        System.out.println(prev[target+total]);
    }
}
