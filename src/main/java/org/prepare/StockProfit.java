package org.prepare;

import java.util.Arrays;
import java.util.List;

public class StockProfit {

    public static void main(String[] args) {

        Integer[] stock_prices = new Integer[]{3,8,19,12,6,19,3,44,6};
        int maxProfit = 0;
        int purchase_price = stock_prices[0];
        System.out.println(" The next purchase price is ...."+getNextPurchasePrice(stock_prices, 5));
        System.out.println(" The next sale price is ...."+ getNextSalePrice(stock_prices, 3));


    }

    /**
     * Purpose of this method to find the next Purchase price. Starting from the next day
     * of the last sale.
     *
     * @param stock_prices
     * @param start_index
     * @return
     */
    public static int getNextPurchasePrice(Integer[] stock_prices, int start_index) {
        int min_price = 0;
        for (int i = start_index; i < stock_prices.length; i++) {
            min_price = stock_prices[i];
            for (int j = i + 1; j < stock_prices.length; j++) {
                if (min_price > stock_prices[j]) {
                    min_price = stock_prices[j];
                }
            }
        }

        return min_price;

    }
        /**
         * Purpose is to find the next sale price of the stock.
         *
         * @param stock_prices
         * @return
         */
        public static int getNextSalePrice(Integer[] stock_prices, int price_index){
            for(int i = price_index ; i <stock_prices.length; i++){
                for(int j=i+1; i< stock_prices.length; j++) {
                    if(stock_prices[j] > stock_prices[j+1] ){
                        return stock_prices[j];
                    }
                }
            }

            return 0;
        }
}
