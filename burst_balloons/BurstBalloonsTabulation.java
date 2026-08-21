package burst_balloons;


public class BurstBalloonsTabulation{

    public static void main(String[] args){
        int[] nums = {3,1,5,8};
        int size = nums.length;

        int[] numsUpdated = new int[size+2];

        for(int i=0; i<size; i++){
            numsUpdated[i+1] = nums[i]; 
        }

        numsUpdated[0] = 1;
        numsUpdated[size+1] = 1;

        int[][] dp = new int[size+2][size+2];

        for(int i = size; i>=1; i--){
            for(int j = i; j<=size; j++){
                int max = Integer.MIN_VALUE;
                for(int k=i; k<=j; k++){

                    int coins = numsUpdated[i-1] * numsUpdated[k] * numsUpdated[j+1] + dp[i][k-1] + dp[k+1][j];
                    max = Math.max(max, coins);
                }

                dp[i][j] = max;
            }
        }

        System.out.println(dp[1][size]);
    }
}