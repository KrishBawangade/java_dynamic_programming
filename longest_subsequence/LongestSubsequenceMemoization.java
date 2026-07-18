package longest_subsequence;

import java.util.Arrays;

public class LongestSubsequenceMemoization {

    public static int longestCommonSubsequence(String text1, String text2, int[][] dp, int i, int j){
        
        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1+ longestCommonSubsequence(text1, text2, dp, i-1, j-1);
        }else{
            return dp[i][j] = Math.max(
                longestCommonSubsequence(text1, text2, dp, i-1, j), 
                longestCommonSubsequence(text1, text2, dp, i, j-1)
            );
        }

    } 

    public static void main(String[] args){
        String text1 = "abcde";
        String text2 = "ace";

        int l1 = text1.length();
        int l2 = text2.length();

        int[][] dp = new int[l1][l2];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(longestCommonSubsequence(text1, text2, dp, l1-1, l2-1));
    }
}
