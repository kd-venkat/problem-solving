class Solution {
    public int orangesRotting(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;

       Queue<int []> que = new LinkedList<>();

       int dx[] = {-1,0,1,0};
       int dy[] = {0,-1,0,1};

       int total = 0;

       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]==2)
            {
                que.add(new int[]{i,j});
            }

            if(grid[i][j] !=0)
            {
                total++ ;
            }

        }
       }
       int rotten=0,time = 0;

       while(!que.isEmpty())
       {
        rotten += que.size();
        int size = que.sieze();
        for(int i=0;i<size;i++)
        {
        int nn[] = que.poll();
        int x = nn[0];
        int y = nn[1];
        for(int k=0;k<4;k++)
        {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]==1)
            {
                grid[nx][ny]= 2;
                que.add(new int[]{nx,ny});
            }
        }
        }

        if(!que.isEmpty())
        {
            time++;
        }
       }

       return total == rotten ? time : -1;
        
    }
}