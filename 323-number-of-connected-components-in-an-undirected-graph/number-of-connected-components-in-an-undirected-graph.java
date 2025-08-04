class Solution {
    public int countComponents(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++)map.put(i, new ArrayList<>());
        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int count =0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i, map, visited);
                count++;
            }
        }

        return count;
    }


    public void dfs(int node, Map<Integer, List<Integer>> map, Set<Integer> visited){
        if(visited.contains(node))return;

        visited.add(node);

        for(int currNode: map.get(node)){
            dfs(currNode, map, visited);
        }
    }
}

// check if there are enough edges i.e for n nodes n-1 edges should be there. 
// then maintain a visited array and run it for each element if its not visited 
// run a dfs add all to visited and increase the count of edge 
// run it for rest of the nodes and increment conected count. 