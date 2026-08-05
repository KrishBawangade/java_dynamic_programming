package longest_string_chain;

import java.util.Arrays;

public class LongestStringChain {

    public static int longestStrChain(String[] words) {
        int size = words.length;

        Arrays.sort(words, (s1,s2) -> Integer.compare(s1.length(), s2.length()));

        int[] dp = new int[size];

        Arrays.fill(dp, 1);

        int maxi = 1;

        for(int i=0; i<size; i++){
            for(int p=0; p<i; p++){

                if(isValid(words[p], words[i])){
                    if(1+ dp[p] > dp[i]){
                        dp[i] = 1 + dp[p];
                    }
                }
            }

            if(dp[i] > maxi){
                maxi = dp[i];
            }
        }

        return maxi;
    }

    public static boolean isValid(String s1, String s2){
        if(s1.length()+1 != s2.length()){
            return false;
        }

        int i=0;
        int j=0;

        int matchFound = s1.length();

        while(matchFound != 0 && (i<s1.length() && j<s2.length())){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(j);

            if(ch1 == ch2){
                i++;
                j++;
                matchFound--;
            }else{
                j++;
            }
        }

        return matchFound == 0;
    }



    public static void main(String[] args){
        String[] words = {"a","aa","aab","aabb","bbaac"};

        System.out.println(longestStrChain(words));
    }
}
