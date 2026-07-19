package longest_common_substring;

public class LongestCommonSubstringTabulation {
    public static void main(String[] args){
        String text1 = "abcde";
        String text2 = "adbcg";

        int l1 = text1.length();
        int l2 = text2.length();

        int[][] dp = new int[l1+1][l2+1];

        int max = 0;

        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
