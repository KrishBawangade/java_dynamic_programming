package rod_cutting;

import java.util.Arrays;

public class RodCuttingMemoization {

    public static int rodCutting(int[] price, int[][] dp, int n, int length){
        if(length == 0){
            return 0;
        }

        if(n==0){
            return n+1<=length? price[n] * (length/(n+1)) : 0 ;
        }

        if(dp[n][length] != -1){
            return dp[n][length];
        }

        int pick = Integer.MIN_VALUE;

        if(n+1<=length){
            pick = price[n] + rodCutting(price, dp, n, length-(n+1));
        }

        int nonPick = rodCutting(price, dp, n-1, length);

        return dp[n][length] = Math.max(pick, nonPick);
    }

    public static void main(String[] args){
        int[] price = {2,5,7,8,10};
        int length = 5;

        int size = price.length;

        int[][] dp = new int[size][length+1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(rodCutting(price, dp, size-1, length));
    }
}
