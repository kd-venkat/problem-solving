    class Solution {
        
        public boolean dfs(int node, int parent, boolean visited[],ArrayList<ArrayList<Integer>> adj)
        {
            visited[node] = true;
            
            for(int nnode : adj.get(node))
            {
                if(!visited[nnode])
                {
                    dfs(nnode,node,visited,adj);
                }
                else if( nnode != parent)
                {
                    return true;
                }
            }
            
            return false;
        }
        public boolean isCycle(int V, int[][] edges) {
            // Code here
            
            ArrayList<ArrayList<Integer>> adj =new  ArrayList<>();
            
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<>());
                
            }
            
            for(int nedge[] : edges)
            {
                int u = nedge[0];
                int v = nedge[1];
                
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            
            boolean visited[] = new boolean[V];
            
            for(int i=0;i<V;i++)
            {
                if(!visited[i])
                {
                    if(dfs(i,-1,visited,adj)) return true;
                    
                }
            }
            
            return false;
            
        }
    }