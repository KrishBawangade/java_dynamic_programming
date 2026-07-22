package shortest_common_supersequence;

public class ShortestCommonSupersequence {

    public static void main(String[] args){
        String str1 = "brute";
        String str2 = "groot";

        int l1 = str1.length();
        int l2 = str2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){

                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    
                    dp[i][j] = Math.max(
                        dp[i-1][j],
                        dp[i][j-1]
                    );
                }
            }
        }

        StringBuilder scs = new StringBuilder();

        int i=l1;
        int j=l2;

        while(i>0 && j>0){

            if(str1.charAt(i-1) == str2.charAt(j-1)){
                scs.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    scs.append(str1.charAt(i-1));
                    i--;
                }else{
                    scs.append(str2.charAt(j-1));
                    j--;
                }
            }
        }

        while(j>0){
            scs.append(str2.charAt(j-1));
            j--;
        }

        while(i>0){
            scs.append(str1.charAt(i-1));
            i--;
        }
            
        System.out.println(scs.reverse().toString());
        
    }
}
