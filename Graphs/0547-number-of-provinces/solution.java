class Solution {
    public int findCircleNum(int[][] adj) 
    {
        int count = 0;
        int n = adj.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(adj,i,visited);
            }
        }
        return count;
    }
    public void dfs(int adj[][], int i, boolean[] visited)
    {
        visited[i] = true;
        for(int j = 0; j < adj.length; j++)
        {
            if(adj[i][j] == 1 && !visited[j])
            {
                dfs(adj,j,visited);
            }
        }
    }
        
}
