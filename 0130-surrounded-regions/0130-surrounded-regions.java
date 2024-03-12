class Solution {
    public void dfs (int r,int c, int [][] vis,char[][] arr,int []dr, int [] dc){
        vis[r][c] = 1;
        int n= arr.length;
        int m = arr[0].length;
        for (int i=0;i<4;i++){
            int nr= r+dr[i];
            int nc= c+dc[i];
            if (nr>=0 && nr<n && nc>=0 && nc<m && arr[nr][nc]=='O' && vis[nr][nc]==0){
                dfs(nr,nc,vis, arr, dr, dc);
            }
        }
    }

    public void solve(char[][] arr) {
        int n= arr.length;
        int m=arr[0].length;

        int vis[][] = new int [n][m];
        int dr[]={0,0,1,-1};
        int dc[]={1,-1,0,0};

        for (int i=0;i<n;i++){

            // if 1st column have o and it is unvisited then travese them 
            if (arr[i][0]=='O' && vis[i][0]==0){
                dfs(i,0,vis,arr,dr,dc);
            }

            // if last column 
            if (arr[i][m-1]=='O'&& vis[i][m-1]==0){
                dfs(i,m-1,vis,arr,dr,dc);
            }
        }


//          FOR ROW =>
        for (int j=0;j<m;j++){
            // if 1st row have o and it is unvisited then travese them 
            if (arr[0][j]=='O' && vis[0][j]==0){
                dfs(0,j,vis,arr,dr,dc);
            }

            // if last row 
            if (arr[n-1][j]=='O' && vis[n-1][j]==0){
                dfs(n-1,j,vis,arr,dr,dc);
            }
        }



        // update our matrix 
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (vis[i][j]==0  &&  arr[i][j]=='O' )       arr[i][j]='X';
            }
        }
        // return arr;
    }
}