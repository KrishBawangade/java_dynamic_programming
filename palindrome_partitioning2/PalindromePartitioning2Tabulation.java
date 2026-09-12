package palindrome_partitioning2;

public class PalindromePartitioning2Tabulation {

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

        for(int i=n-2; i>=0; i--){
            for(int j = i+1; j<n; j++){

                if(isPalindrome(s, i, j)){
                    dp[i][j] = 0;
                    continue;
                }

                int min = Integer.MAX_VALUE;

                for(int k=i+1; k<=j; k++){
                    if(isPalindrome(s, i, k-1)){
                        int cuts = 1+ dp[k][j];
                        min = Math.min(min, cuts);
                    }
                }

                dp[i][j] = min;
            }
        }

        System.out.println(dp[0][n-1]);
    }
}
