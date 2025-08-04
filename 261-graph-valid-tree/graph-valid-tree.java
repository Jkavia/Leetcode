class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length >= n)return false;
        Set<Integer> visited = new HashSet<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++)map.put(i, new ArrayList<>());
        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        dfs(0, map, visited);

        return visited.size() == n;
    }

    public void dfs(int node, Map<Integer, List<Integer>> map, Set<Integer> visited){
        if(visited.contains(node))return;
        visited.add(node);

        for(int currNode: map.get(node)){
            dfs(currNode, map, visited);
        }
    }
}

// so if there are loops then we'll have equal to or more edges than nodes. 
// therefore, one check is to ensure edges = n-1
// next thing thats left for validity is all nodes should be connected so we start from 0
// and track visited and after 1 round of dfs if all nodes are not visited then we know 
// that its not valid. 