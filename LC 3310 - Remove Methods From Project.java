class Solution {
    public List<Integer> remainingMethods(int n, int K, int[][] invocations) {

        //O(V + E) 
        //O(V + E)

        int[] inDegree = new int[n];
        boolean[] visited = new boolean[n];

        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            adjList.add(new ArrayList<>());

        for(int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];
            inDegree[v]++;
            adjList.get(u).add(v);
        }    

        dfs(K, adjList, visited, inDegree);    

        boolean ok = false;
        for(int node = 0; node < n; ++node) {

            //If visited node with inDegree > 0 means node is connected with non suspicious method
            //In this case we will return all nodes
            if(visited[node] && inDegree[node] > 0) {
                ok = true;
                break;
            }

            //non suspicious method
            if(!visited[node]) 
                result.add(node);
        }

        if(ok) {
            result.clear();
            for(int node = 0; node < n; ++node)
                result.add(node);
        }
        return result;        
    }

    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited, int[] inDegree) {
        visited[node] = true;
        for(int adjNode : adjList.get(node)) {
            inDegree[adjNode]--;
            if(!visited[adjNode]) {
                dfs(adjNode, adjList, visited, inDegree);
            }
        }
    }
}