/**
**On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
**
**Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top 
**of the floor, and you can either start from the step with index 0, or the step with index 1.
**/


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] opt = new int[n];
        
        opt[n-1] = cost[n-1];
        opt[n-2] = cost[n-2];
        
        for (int i = n-3; i >= 0; i--){
            opt[i] = Math.min(cost[i] + opt[i+1], cost[i] + opt[i+2]);
        }
        
        return Math.min(opt[0], opt[1]);
    }
}