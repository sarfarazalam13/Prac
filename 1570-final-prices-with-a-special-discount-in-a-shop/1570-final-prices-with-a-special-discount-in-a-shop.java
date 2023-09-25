class Solution {

    static void searchDiscount(int i, int[] prices){
        if(i < prices.length-1){
            for(int j=i+1; j<prices.length; j++){
                if(prices[j] <= prices[i]){
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
    }

    public int[] finalPrices(int[] prices) {
        for(int i=0; i<prices.length; i++){
            searchDiscount(i,prices);
        }
        return prices;
    }
}