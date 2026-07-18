package print_longest_subsequence;

public class PrintLCSTabulationStandard {
    public static void main(String[] args){
        String text1 = "abcde";
        String text2 = "ace";

        int l1 = text1.length();
        int l2 = text2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    
                    dp[i][j] = Math.max(
                        dp[i-1][j],
                        dp[i][j-1]
                    );
                }
            }
        }

        String lcs = "";
        int len = dp[l1][l2];

        int i=l1;
        int j=l2;

        while(len>0){

            if(text1.charAt(i-1) == text2.charAt(j-1)){
                lcs = text1.charAt(i-1)+lcs;
                len--;
                i--;
                j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
            
        System.out.println(lcs);
        
    }
}
