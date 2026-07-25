package wildcard_matching;

public class WildcardMatchingMemoization {
    public static boolean isMatch(String s, String p, Boolean[][] dp, int i, int j) {
        if(i<0 && j<0){
            return true;
        }

        if(i<0){
           while(j>=0){
                if(p.charAt(j) != '*'){
                    return false;
                }

                j--;
           }
           return true;
        }

        if(j<0){
            return false;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j]= isMatch(s, p, dp, i-1, j-1);
        }else{

            if(p.charAt(j) == '*'){
                return dp[i][j] = isMatch(s, p, dp, i-1, j) || isMatch(s, p, dp, i, j-1);
            }

            return dp[i][j] = false;
        }
    }

    public static void main(String[] args){
        String s= "abbbsb";
        String p= "a*b";

        int l1 = s.length();
        int l2 =p.length();

        Boolean[][] dp = new Boolean[l1][l2];

        System.out.println(isMatch(s,p,dp,l1-1,l2-1));
    }
}
