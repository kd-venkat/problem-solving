class Solution {
    public void depth(int node, ArrayList<ArrayList<Integer>> adj, boolean visited[], ArrayList<Integer> result)
    {
        visited[node] = true;
        
        result.add(node);
        
        for(int nnode : adj.get(node))
        {
           // System.out.println(nnode);
            if(!visited[nnode] )
            {
                depth(nnode, adj,visited,result);
            }
        }
        
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[] = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();
        
        depth(0,adj,visited,result);
        return result;
    }
}