package distinct_subsequences;

public class DistinctSubsequencesTabulation {

    public static void main(String[] args){
        String s = "babgbag";
        String t = "bag";

        int l1 = s.length();
        int l2 = t.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i=0; i<=l1; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                // matched character
                if(s.charAt(i-1) == t.charAt(j-1)){
                    int path1 = dp[i-1][j-1];
                    int path2 = dp[i-1][j];

                    dp[i][j] = path1+path2;
                }else{
                    // not matched
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        System.out.println(dp[l1][l2]);
    }
}
