package partition_array_max_sum;

public class PartitionArrayMaxSumTabulation {
    public static void main(String[] args){
        int[] arr = {1,15,7,9,2,5,10};
        int k=3;

        int n = arr.length;

        int[] dp = new int[n+1];

        for(int i=n-1; i>=0; i--){

            int maxSum = Integer.MIN_VALUE;

            int max = arr[i];

            for(int p = i+1; p<=Math.min(i+k, n); p++){

                max = Math.max(max, arr[p-1]);

                int sum = max * ((p-1)-i+1) + dp[p];

                maxSum = Math.max(maxSum, sum);
            }

            dp[i] = maxSum;
            
        }

        System.out.println(dp[0]);
    }
}
