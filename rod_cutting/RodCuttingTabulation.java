package rod_cutting;

public class RodCuttingTabulation {

    public static void main(String[] args){
        int[] price = {2,5,7,8,10};
        int length = 5;

        int size = price.length;

        int[][] dp = new int[size][length+1];

        for(int i=0; i<size; i++){
            dp[i][0] = 0;
        }

        for(int l = 1; l<=length; l++){
            dp[0][l] = price[0] * l;
        }

        for(int n=1; n<size; n++){
            for(int l=1; l<=length; l++){
                int pick = Integer.MIN_VALUE;

                if(n+1<=l){
                    pick = price[n] + dp[n][l-(n+1)];
                }

                int nonPick = dp[n-1][l];

                dp[n][l] = Math.max(pick, nonPick);
            }
        }

        System.out.println(dp[size-1][length]);
    }
}
