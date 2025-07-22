class Solution {
    // make sure all the nodes are visited 
    // and do not visit a node twice unless its a parent. 
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            map.get(x).add(y);
            map.get(y).add(x);
        }
        checkCycles(map,visited, 0);

        return visited.size() == n && edges.length == n-1;
    }

    public void checkCycles(Map<Integer, List<Integer>> map, Set<Integer> visited, int node){
        // dont let them add if its visited, 
        if(visited.contains(node))return;

        visited.add(node);
        //System.out.println(visited.toString());
        for(int n:map.get(node)){
            checkCycles(map, visited, n);
        }
    }


}