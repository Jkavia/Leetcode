class Solution {
    // just count the nodes with indegree 0
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] edge:edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int count =0;
        Set<Integer> visited = new HashSet<>();

        for(int i=0;i<n;i++){

            if(!visited.contains(i)){
                count++;
                dfs(map, i, visited);
                }
        }

        return count;
    }


    public void dfs(Map<Integer, List<Integer>> map, int node, Set<Integer> visited){
        if(visited.contains(node))return;
        visited.add(node);
        for(int n: map.get(node)){
            dfs(map, n, visited);
        }
    }
}