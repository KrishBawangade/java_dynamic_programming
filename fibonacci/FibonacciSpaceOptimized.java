package fibonacci;

public class FibonacciSpaceOptimized {
    public static void main(String[] args){
        int n = 6;

        int prev2= 0;
        int prev1= 1;

        if(n<=1){
            System.out.println(n);
            return;
        }

        for(int i=2; i<=n; i++){
            int temp = prev1+ prev2;

            prev2 = prev1;
            prev1 = temp;
        }

        System.out.println(prev1);
    } 
}
