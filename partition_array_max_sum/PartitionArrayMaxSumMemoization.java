package partition_array_max_sum;

import java.util.Arrays;

public class PartitionArrayMaxSumMemoization {

    public static int maxArraySum(int[] arr, int k, int[] dp, int i, int j){
        if(i == j){
            return arr[i];
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int maxSum = Integer.MIN_VALUE;

        // for no partitioning 
        if(j-i+1 <= k){
            int max = arr[i];

            for(int n=i+1; n<=j; n++){
                max = Math.max(max, arr[n]);
            }

            maxSum = max* (j-i+1);
        }


        int max = arr[i];

        for(int p = i+1; p<=Math.min(i+k, j); p++){

            max = Math.max(max, arr[p-1]);

            int sum = max * ((p-1)-i+1) + maxArraySum(arr, k, dp, p, j);

            maxSum = Math.max(maxSum, sum);
        }

        return dp[i] = maxSum;
    }

    public static void main(String[] args){
        int[] arr = {1,15,7,9,2,5,10};
        int k=3;

        int n = arr.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        System.out.println(maxArraySum(arr, k, dp, 0, n-1));
    }
}
