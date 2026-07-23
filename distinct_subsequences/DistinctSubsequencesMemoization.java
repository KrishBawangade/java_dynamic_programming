package distinct_subsequences;

import java.util.Arrays;

public class DistinctSubsequencesMemoization {

    public static int numDistinct(String s, String t, int[][] dp, int i, int j) {
        if(j<0){
            return 1;
        }

        if(i<0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // matched character
        if(s.charAt(i) == t.charAt(j)){
            int path1 = numDistinct(s, t, dp, i-1, j-1);
            int path2 = numDistinct(s, t, dp, i-1, j);

            return dp[i][j] = path1+path2;
        }else{
            // not matched
            return dp[i][j]= numDistinct(s,t, dp, i-1, j);
        }
    }

    public static void main(String[] args){
        String s = "babgbag";
        String t = "bag";

        int l1 = s.length();
        int l2 = t.length();

        int[][] dp = new int[l1][l2];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(numDistinct(s,t, dp, l1-1, l2-1));
    }
}
