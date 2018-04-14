/**
**Follow up for "Unique Paths":
**
**Now consider if some obstacles are added to the grids. How many unique paths would there be?
**
**An obstacle and empty space is marked as 1 and 0 respectively in the grid.
**/

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid.at(0).size();
        
        int opt[m][n];
        bool flagx = true;
        bool flagy = true;
        for (int i = 0; i < m; i++)
        {
            if (obstacleGrid.at(i).at(0) == 0 && flagx)
                opt[i][0] = 1;
            else
            {
                opt[i][0] = 0;
                flagx = false;
            }
                
        }
        

        for (int i = 0; i < n; i++)
        {
            if (obstacleGrid.at(0).at(i) == 0 && flagy)
                opt[0][i] = 1;
            else
            {
                opt[0][i] = 0;
                flagy = false;
            }
        }
        
        
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (obstacleGrid.at(i).at(j) == 0)
                    opt[i][j] = opt[i-1][j] + opt[i][j-1];
                else
                    opt[i][j] = 0;
            }
        }
        
        return opt[m-1][n-1];
        
    }
};