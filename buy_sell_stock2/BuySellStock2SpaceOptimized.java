package buy_sell_stock2;

public class BuySellStock2SpaceOptimized {
    public static void main(String[] args){
        int[] prices= {1,2,3,4,5};

        int size = prices.length;

        int nextBuy = 0;
        int nextSell = 0;

        for(int i=size-1; i>=0; i--){

            int currBuy = Math.max(-prices[i] + nextSell, nextBuy);
            int currSell = Math.max(prices[i] + nextBuy, nextSell);

            nextBuy = currBuy;
            nextSell = currSell;

        }

        System.out.println(nextBuy);
    } 
}
