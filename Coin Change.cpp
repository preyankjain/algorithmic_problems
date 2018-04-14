/**
**You are given coins of different denominations and a total amount of money amount.
**Write a function to compute the fewest number of coins that you need to make up that amount.
**If that amount of money cannot be made up by any combination of the coins, return -1.
**/

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int len = coins.size();
        int opt[amount + 1];
        opt[0] = 0;
        int min;
        for (int i = 1; i <= amount; i++)
        {
            min = 100;
            for (int j = 0; j < len; j++)
            {
                if((i - coins.at(j)) >= 0 && opt[i - coins.at(j)] != -1)
                {
                    if ((1 + opt[i - coins.at(j)]) < min)
                        min = 1 + opt[i - coins.at(j)];
                }
            }
            if(min != 100)
                opt[i] = min;
            else
                opt[i] = -1;
        }
        
        return opt[amount];
        
    }
};