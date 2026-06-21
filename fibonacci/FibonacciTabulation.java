package fibonacci;

public class FibonacciTabulation {
    public static void main(String[] args){
        int n = 6;
        int[] dpArr = new int[n+1];

        dpArr[0] = 0;

        dpArr[1] = 1;

        for(int i=2; i<=n; i++){
            dpArr[i] = dpArr[i-1] + dpArr[i-2];
        }

        System.out.println(dpArr[n]);
    } 
}
