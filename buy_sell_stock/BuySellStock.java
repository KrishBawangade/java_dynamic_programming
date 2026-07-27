package buy_sell_stock;

public class BuySellStock {

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int size = prices.length;

        int min = 0;

        int profit = 0;
        
        for(int i=min+1; i<size; i++){
            
            profit = Math.max(profit, prices[i]-prices[min]);
            
            if(prices[i]<prices[min]){
                min = i;
            }
        }

        System.out.println(profit);
    }
}
