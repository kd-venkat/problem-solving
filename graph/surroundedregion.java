class Solution {

    public void dfs(int r, int c, char[][] board)
    {
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c] != 'O')
            return;

        board[r][c] = '#';
    
        dfs(r-1,c,board);
        dfs(r+1,c,board);
        dfs(r,c-1,board);
        dfs(r,c+1,board);
    }

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // boundary rows
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O') dfs(0,i,board);
            if(board[m-1][i]=='O') dfs(m-1,i,board);
        }

        // boundary columns
        for(int j=0;j<m;j++)
        {
            if(board[j][0]=='O') dfs(j,0,board);
            if(board[j][n-1]=='O') dfs(j,n-1,board);
        }

        // flip surrounded regions
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O')
                    board[i][j]='X';

                if(board[i][j]=='#')
                    board[i][j]='O';
            }
        }
    }
}