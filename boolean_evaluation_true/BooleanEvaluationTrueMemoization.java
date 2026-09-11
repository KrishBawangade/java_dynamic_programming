package boolean_evaluation_true;

import java.util.Arrays;

public class BooleanEvaluationTrueMemoization{

    public static int evalWays(String evalStr, int[][][] dp, int i, int j, boolean isTrue){
        if(i>j){
            return 0;
        }

        
        if(i==j){
            char ch = evalStr.charAt(i);
            if(isTrue){
                return (ch == 'T'? 1: 0);
            }else{
                return (ch == 'F'? 1:0);
            }
        }

        int truthIndex = isTrue? 1: 0;

        if(dp[i][j][truthIndex] != -1){
            return dp[i][j][truthIndex];
        }
        
        int ways = 0;

        for(int k = i+1; k<=j-1; k+=2){
            int lT = evalWays(evalStr, dp, i, k - 1, true);
            int rT = evalWays(evalStr, dp, k + 1, j, true);

            int lF = evalWays(evalStr, dp, i, k - 1, false);
            int rF = evalWays(evalStr, dp, k + 1, j, false);

            char ch = evalStr.charAt(k);

            if(isTrue){
                if(ch == '&'){
                    ways += lT * rT;
                }

                if(ch == '|'){
                    ways += (lT * rF) + (lF * rT) + (lT* rT); 
                }

                if(ch == '^'){
                    ways += (lT * rF) + (lF * rT);
                }
            }else{
                if(ch == '&'){
                    ways += (lT * rF) + (lF * rT) + (lF* rF);
                }

                if(ch == '|'){
                    ways += lF * rF; 
                }

                if(ch == '^'){
                    ways += (lT * rT) + (lF * rF);
                }
            }

        }
        return dp[i][j][truthIndex] = ways;
    }

    public static void main(String[] args){
        String evalStr = "T|F&T";

        int n = evalStr.length();

        int[][][] dp = new int[n][n][2];
        
        for(int[][] arr: dp){
            for(int[] row: arr){
                Arrays.fill(row, -1);
            }
        }

        System.out.println(evalWays(evalStr, dp, 0, n-1, true));
    }
}