package print_longest_subsequence;

import java.util.Arrays;

public class PrintLCSSpaceOptimized {
    public static void main(String[] args){
        String text1 = "abcde";
        String text2 = "ace";

        int l1 = text1.length();
        int l2 = text2.length();

        String[] prev = new String[l2+1];
        String[] curr = new String[l2+1];

        Arrays.fill(prev, "");
        Arrays.fill(curr, "");

        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = prev[j-1] + text1.charAt(i-1);
                }else{

                    String s1 = prev[j];
                    String s2 = curr[j-1];

                    if(s1.length()>s2.length()){
                        curr[j] = s1;
                    }else{
                        curr[j] = s2;
                    }
                    
                }
            }
            String[] temp = prev;
            prev = curr;
            curr = temp;

            Arrays.fill(curr, "");
        }

        System.out.println(prev[l2]);
    }
}
