package print_longest_subsequence;

public class PrintLCSTabulation {
    public static void main(String[] args){
        String text1 = "abcde";
        String text2 = "ace";

        int l1 = text1.length();
        int l2 = text2.length();

        String[][] dp = new String[l1+1][l2+1];

        for (int i = 0; i <= l1; i++) {
            dp[i][0] = "";
        }

        for (int j = 0; j <= l2; j++) {
            dp[0][j] = "";
        }

        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){

                    dp[i][j] = dp[i-1][j-1] + text1.charAt(i-1);
                }else{

                    String s1 = dp[i-1][j];
                    String s2 = dp[i][j-1];

                    if(s1.length()>s2.length()){
                        dp[i][j] = s1;
                    }else{
                        dp[i][j] = s2;
                    }
                }
            }
        }

        System.out.println(dp[l1][l2]);
    }
}
