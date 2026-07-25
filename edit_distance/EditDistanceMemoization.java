package edit_distance;

import java.util.Arrays;

public class EditDistanceMemoization {

    public static int minDistance(String word1, String word2, int[][] dp, int i, int j) {

        // insert remaining characters
        if(i<0){
            return j+1;
        }

        // remove remaining characters
        if(j<0){
            return i+1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        //match found
        if(word1.charAt(i) == word2.charAt(j)){
            return minDistance(word1, word2, dp, i-1, j-1);
        }else{
            //replace
            int replace = minDistance(word1, word2, dp, i-1, j-1);

            //insert
            int insert = minDistance(word1, word2, dp, i, j-1);

            //remove
            int remove = minDistance(word1, word2, dp, i-1, j);

            return dp[i][j] = 1 + Math.min(replace, Math.min(insert, remove));
        }
    }

    public static void main(String[] args){

        String word1 = "intention";
        String word2 = "execution";

        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1][l2];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(minDistance(word1, word2, dp, l1-1, l2-1));
    }
}
