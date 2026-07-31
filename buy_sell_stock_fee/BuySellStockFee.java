package buy_sell_stock_fee;

public class BuySellStockFee {
    public static void main(String[] args){
        int[] prices= {1,3,2,8,4,9};
        int fee = 2;

        int size = prices.length;

        int nextBuy = 0;
        int nextSell = 0;

        for(int i=size-1; i>=0; i--){

            int currBuy = Math.max(-prices[i] + nextSell, nextBuy);
            int currSell = Math.max((prices[i]-fee) + nextBuy, nextSell);

            nextBuy = currBuy;
            nextSell = currSell;

        }

        System.out.println(nextBuy);
    }
}
