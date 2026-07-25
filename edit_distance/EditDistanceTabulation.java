package edit_distance;

public class EditDistanceTabulation {

    public static void main(String[] args){

        String word1 = "intention";
        String word2 = "execution";

        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i=1; i<=l1; i++){
            dp[i][0] = i;
        }

        for(int j=1; j<=l2; j++){
            dp[0][j] = j;
        }

        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                //match found
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        System.out.println(dp[l1][l2]);
    }
}
