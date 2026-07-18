package rod_cutting;

public class RodCuttingSpaceOptimized {
    public static void main(String[] args){
        int[] price = {2,5,7,8,10};
        int length = 5;

        int size = price.length;

        int[] prev = new int[length+1];

        prev[0] = 0;

        for(int l = 1; l<=length; l++){
            prev[l] = price[0] * l;
        }

        for(int n=1; n<size; n++){

            for(int l=n+1; l<=length; l++){
                int pick = price[n] + prev[l-(n+1)];

                int nonPick = prev[l];

                prev[l] = Math.max(pick, nonPick);
            }

        }

        System.out.println(prev[length]);
    }
}
