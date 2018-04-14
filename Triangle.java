/**
**Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
**/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        
        int[][] opt = new int[n][n];
        
        opt[0][0] = triangle.get(0).get(0);
        
        int k = 0;
        int m = 0;
        
        for (int i = 1; i < n; i++)
        {
            k = Math.max(0,m-1);
            System.out.println(k);
            m = triangle.get(i).size();
            for(int j = 0; j < m; j++)
                opt[i][j] = Math.min(opt[i-1][Math.max(0,j-1)] + triangle.get(i).get(j), opt[i-1][Math.min(j,k)] + triangle.get(i).get(j));
        }
        
        int min = opt[n-1][0];
        for (int i = 1; i < m; i++)
        {
            min = Math.min(min, opt[n-1][i]);
        }
        return min;
    }
}