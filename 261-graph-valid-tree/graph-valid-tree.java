class Solution {
    // if there is only one path to each of the nodes 
    // that means for n nodes there will always be n-1 edges.
    // now then the only thing that is left to test is if 
    // all th edges are visited for that we'll track a visited set 
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1)return false;

        Set<Integer> visited = new HashSet<>();
        // create an adjaccency map
        Map<Integer, List<Integer>> adjacency = new HashMap<>();

        for(int i=0;i<n;i++){
            adjacency.put(i, new ArrayList<>());
        }

        for(int[] edge:edges){
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }

        checkVisited(adjacency, visited, 0);

        return visited.size()==n;
    }

    public void checkVisited(Map<Integer, List<Integer>> adjacency, Set<Integer> visited, int node){
        if(visited.contains(node))return;

        visited.add(node);

        List<Integer> neighbors = adjacency.get(node);

        for(int n: neighbors){
            checkVisited(adjacency, visited, n);
        }
    }

}