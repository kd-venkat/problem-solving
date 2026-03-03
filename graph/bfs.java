class Solution {
    
    public void bfstraversal(int node,ArrayList<ArrayList<Integer>> adj, boolean visited[],ArrayList<Integer> result )
    {
        Queue<Integer> que = new LinkedList<>();
        
        visited[node] = true;
        que.add(node);
        
        while(!que.isEmpty())
        {
            int nnode  = que.poll();
            result.add(nnode);
            
            for(int a : adj.get(nnode))
            {
                if(!visited[a])
                {
                    que.add(a);
                    visited[a] = true;
                }
            }
        }
        
    }
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        ArrayList<Integer> result = new ArrayList<>();
        
        boolean visited[] = new boolean[adj.size()];
        
        bfstraversal(0,adj,visited,result);
        
        return result;
        
    }
}