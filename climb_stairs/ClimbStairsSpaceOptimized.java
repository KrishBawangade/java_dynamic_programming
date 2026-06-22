package climb_stairs;

public class ClimbStairsSpaceOptimized {

    public static void main(String[] args){

        int n = 5;

        int prev1 = 1;
        int prev2 = 1;

        for(int i=2; i<=n; i++){
            int temp = prev1+prev2;
            prev2 = prev1;
            prev1 = temp;
        }

        System.out.println(prev1);
    }
}
