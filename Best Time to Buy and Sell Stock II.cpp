/**
**Say you have an array for which the ith element is the price of a given stock on day i.
**
**Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and 
**sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time 
**(ie, you must sell the stock before you buy again).
**/


class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0)
            return 0;
        int n = prices.size();
        int cash = 0;
        int hold = 0 - prices.at(0);
        
        for (int i = 1; i < n; i++)
        {
            cash = max(cash, hold + prices[i]);
            hold = max(hold, cash - prices[i]);
        }
        
        return cash;
        
    }
};