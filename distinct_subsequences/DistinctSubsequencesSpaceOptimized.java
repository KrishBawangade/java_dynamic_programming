package distinct_subsequences;

public class DistinctSubsequencesSpaceOptimized {
    public static void main(String[] args){
        String s = "babgbag";
        String t = "bag";

        int l1 = s.length();
        int l2 = t.length();

        int[] prev = new int[l2+1];

        prev[0] = 1;

        for(int i=1; i<=l1; i++){
            for(int j=l2; j>=1; j--){
                // matched character
                if(s.charAt(i-1) == t.charAt(j-1)){
                    prev[j]+=prev[j-1];
                }
            }
        }

        System.out.println(prev[l2]);
    }
}
