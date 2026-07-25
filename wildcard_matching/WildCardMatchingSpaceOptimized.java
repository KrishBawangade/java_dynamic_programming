package wildcard_matching;

public class WildCardMatchingSpaceOptimized {
    public static void main(String[] args){
        String s= "abbbsb";
        String p= "a*b";

        int l1 = s.length();
        int l2 =p.length();

        boolean[] prev = new boolean[l2+1];

        prev[0] = true;

        for(int j=1; j<=l2; j++){
            if(p.charAt(j-1) == '*'){
                prev[j] = prev[j-1]; 
            }
        }

        for(int i=1; i<=l1; i++){
            boolean[] curr = new boolean[l2+1];
            curr[0] = false;

            for(int j=1; j<=l2; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    curr[j]= prev[j-1];
                }else{

                    if(p.charAt(j-1) == '*'){
                        curr[j] = prev[j] || curr[j-1];
                        continue;
                    }

                    curr[j] = false;
                }
            }
            prev = curr;
        }

        System.out.println(prev[l2]);
    }
}
