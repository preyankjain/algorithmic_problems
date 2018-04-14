/**
**Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
**/



class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] opt = new int[m][n];
        
        opt[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++)
        {
            opt[i][0] = opt[i-1][0] + grid[i][0];
        }
        
        for (int i = 1; i < n; i++)
        {
            opt[0][i] = opt[0][i-1] + grid[0][i];
        }
        
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                opt[i][j] = Math.min(grid[i][j] + opt[i-1][j], grid[i][j] + opt[i][j-1]);
            }
        }
        
        return opt[m-1][n-1];
    }
}