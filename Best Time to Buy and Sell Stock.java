/**
**Say you have an array for which the ith element is the price of a given stock on day i.
**
**If you were only permitted to complete at most one transaction (ie, buy one and sell one 
**share of the stock), design an algorithm to find the maximum profit.
**/


class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        
        int[] opt = new int[prices.length];
        
        opt[0] = 0;
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        return profit;
    }
}