package buy_sell_stock3;

public class BuySellStock3SpaceOptimized{
    public static void main(String[] args){
        int[] prices= {3,3,5,0,0,3,1,4};

        int size = prices.length;

        int[][] ahead = new int[2][3]; 

        for(int b=0; b<2; b++){
            for(int c=0; c<3; c++){
                ahead[b][c] = 0;
            }
        }

        ahead[0][0] = 0;
        ahead[1][0] = 0;

        for(int i=size-1; i>=0; i--){

            int[][] curr = new int[2][3];

            curr[0][0] = 0;
            curr[1][0] = 0;

            for(int b=1; b>=0; b--){

                for(int c=2; c>=1; c--){

                    if(b == 1){
                        curr[b][c] = Math.max(
                            -prices[i] + ahead[0][c], 
                            ahead[1][c]
                        );
                    }else{
                        curr[b][c] = Math.max(
                            prices[i] + ahead[1][c-1],
                            ahead[0][c]
                        );
                    }
                    
                }

            }

            ahead = curr;

        }

        System.out.println(ahead[1][2]);
    } 
}