package matrix_chain_multiplication;

public class MCMTabulation {

    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        int size = arr.length;

        int[][] dp = new int[size][size];

        for(int length=2; length<size; length++){
            for(int i=1; i<=size-length; i++){

                int j = i+length-1;

                int min = Integer.MAX_VALUE;

                // partitions
                for(int k=i; k<j; k++){
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j]; 
                    min = Math.min(min, steps);
                }

                dp[i][j] = min;
            }
        }

        System.out.println(dp[1][size-1]);
    }
}
