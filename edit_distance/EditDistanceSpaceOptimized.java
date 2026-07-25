package edit_distance;

public class EditDistanceSpaceOptimized {
    public static void main(String[] args){

        String word1 = "intention";
        String word2 = "execution";

        int l1 = word1.length();
        int l2 = word2.length();

        int[] prev = new int[l2+1];

        for(int j=1; j<=l2; j++){
            prev[j] = j;
        }

        for(int i=1; i<=l1; i++){

            int[] curr = new int[l2+1];
            curr[0] = i;

            for(int j=1; j<=l2; j++){
                //match found
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }else{
                    curr[j] = 1 + Math.min(prev[j-1], Math.min(curr[j-1], prev[j]));
                }
            }

            prev = curr;
        }

        System.out.println(prev[l2]);
    }
}
