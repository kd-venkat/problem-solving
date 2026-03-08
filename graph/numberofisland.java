class Solution {

    public void dfs(int r, int c, char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0')
            return;

        grid[r][c] = '0';

        dfs(r+1,c,grid);
        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        
        return count;
        
    }
}