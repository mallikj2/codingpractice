package org.prepare;

public class StockProfitCalculator {
    public static void main(String[] args) {
        int[] stock_prices = {3, 8, 19, 12, 6, 19, 3, 44, 6};
        System.out.println("Maximum profit: " + calculateMaxProfit(stock_prices));
    }

    /**
     * Purpose of this method to find the next Purchase price. Starting from the next day
     * of the last sale.
     *
     * @param stock_prices
     * @param startIndex
     * @return
     */
    private static int getNextPurchasePrice(int[] stock_prices, int startIndex) {
        for (; startIndex < stock_prices.length - 1 && stock_prices[startIndex] >= stock_prices[startIndex + 1]; startIndex++);
        return stock_prices[startIndex];
    }


    /**
     * Purpose is to find the next sale price of the stock.
     *
     * @param stock_prices
     * @param startIndex
     * @return
     */
    private static int getNextSalePrice(int[] stock_prices, int startIndex) {
        for (; startIndex < stock_prices.length - 1 && stock_prices[startIndex] <= stock_prices[startIndex + 1]; startIndex++);
        return stock_prices[startIndex];
    }

    /**
     * The purpose of this method is to calculate the max profit based on the stock prices.
     *
     * @param stock_prices
     * @return
     */
    public static int calculateMaxProfit(int[] stock_prices) {
        int maxProfit = 0;
        int n = stock_prices.length;

        for (int i = 0; i < n - 1; ) {
            int purchasePrice = getNextPurchasePrice(stock_prices, i);
            i++;

            System.out.println("The Next Purchase Price is ... "+ purchasePrice);
            if (i >= n) break; // Prevent out-of-bounds errors

            int salePrice = getNextSalePrice(stock_prices, i);
            i++;

            System.out.println("The Next Purchase Price is ... "+ salePrice);
            if (salePrice > purchasePrice) {
                maxProfit += salePrice - purchasePrice;
            }
        }
        return maxProfit;
    }
}

