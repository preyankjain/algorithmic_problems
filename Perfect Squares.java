/**
**Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
**
**For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
**/


class Solution {
    public int numSquares(int n) {
        
        int[] opt = new int[n+1];
        opt[0] = 0;
        opt[1] = 1;
        
        int min;
        for (int i = 2; i <= n; i++){
            min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++){
                min = Math.min(opt[i - j*j] + 1, min);
            }
            opt[i] = min;
        }
        
        return opt[n];
    }
}