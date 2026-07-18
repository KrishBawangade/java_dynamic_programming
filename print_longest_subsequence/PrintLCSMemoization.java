package print_longest_subsequence;

public class PrintLCSMemoization {
    public static String longestCommonSubsequence(String text1, String text2, String[][] dp, int i, int j){
        
        if(i<0 || j<0){
            return "";
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = longestCommonSubsequence(text1, text2, dp, i-1, j-1) + text1.charAt(i);
        }else{
            
            String s1 = longestCommonSubsequence(text1, text2, dp, i-1, j);
            String s2 = longestCommonSubsequence(text1, text2, dp, i, j-1);

            if(s1.length()>s2.length()){
                return dp[i][j] = s1;
            }else{
                return dp[i][j] = s2;
            }
            
        }

    } 

    public static void main(String[] args){
        String text1 = "abcde";
        String text2 = "ace";

        int l1 = text1.length();
        int l2 = text2.length();

        String[][] dp = new String[l1][l2];

        System.out.println(longestCommonSubsequence(text1, text2, dp, l1-1, l2-1));
    }
}
