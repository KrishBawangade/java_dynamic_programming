package longest_common_substring;

public class LongestCommonSubstringSpaceOptimized {
    public static void main(String[] args){
        String text1 = "abcde";
        String text2 = "adbcg";

        int l1 = text1.length();
        int l2 = text2.length();

        int[] prev = new int[l2+1];

        int max = 0;

        for(int i=1; i<=l1; i++){
            int[] curr = new int[l2+1];

            for(int j=1; j<=l2; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1+ prev[j-1];
                }else{
                    curr[j] = 0;
                }
                max = Math.max(max, curr[j]);
            }
            prev = curr;
        }

        System.out.println(max);
    }
}
