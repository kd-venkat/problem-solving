    class Solution {
        
        class Pair
        {
            int parent;
            int node;
            
            Pair(int node, int parent)
            {
                 this.node = node;
                 this.parent = parent;
            }
        }
        
        public boolean bfs(int st, boolean visited[], ArrayList<ArrayList<Integer>> adj)
        {
            visited[st]=true;
            Queue< Pair > que = new LinkedList<>();
            que.add(new Pair(st,-1));
            
            while(!que.isEmpty())
            {
                Pair nnode = que.poll();
                
                int node = nnode.node;
                int parent = nnode.parent;
                
                for(int temp : adj.get(node))
                {
                    if(!visited[temp])
                    {
                        visited[temp] = true;
                       que.add(new Pair(temp,node));
                    }
                    else if(parent != temp)
                    {
                        return true;
                    }
                    
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
                    if(bfs(i,visited,adj)) return true;
                    
                }
            }
            
            return false;
            
        }
    }