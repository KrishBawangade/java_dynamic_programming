package palindrome_partitioning2;

import java.util.Arrays;

public class PalindromePartitioning2Memoization {
    public static int minCut(String s, int[][] dp, int i, int j){

        if(i>=j || isPalindrome(s, i, j)){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for(int k=i+1; k<=j; k++){
            if(isPalindrome(s, i, k-1)){
                int cuts = 1+ minCut(s, dp, k, j);
                min = Math.min(min, cuts);
            }
        }

        return dp[i][j] = min;
    }

    public static boolean isPalindrome(String s, int i, int j){

        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args){
        String s = "aab";
        int n = s.length();

        int[][] dp = new int[n][n];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(minCut(s, dp, 0, n-1));
    }
}
