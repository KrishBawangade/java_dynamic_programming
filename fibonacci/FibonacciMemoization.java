package fibonacci;

import java.util.Arrays;

public class FibonacciMemoization{

    public static int fibonacci(int n, int[] dpArr){
        if(n<2){
            return n;
        }

        if(dpArr[n] != -1){
            return dpArr[n];
        }

        return dpArr[n] = fibonacci(n-1, dpArr) + fibonacci(n-2, dpArr);
    }

    public static void main(String[] args){

        int n = 6;

        int[] dpArr = new int[n+1];

        Arrays.fill(dpArr, -1);

        System.out.println(fibonacci(n, dpArr));
    }
}