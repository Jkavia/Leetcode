//similar to mark the islands with the id.
// do union find
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i] = i;

        for(int[] edge: edges){
            int root1 = find(arr, edge[0]);
            int root2 = find(arr, edge[1]);
            // if they're already not marked as same island we need to mark it as same island.
            if(root1 != root2){
                arr[root1] = root2;
                n--;
            }
        }
        return n;
    }


    public int find(int[] arr, int id){

        while(arr[id] != id){
            //do this to get to the parent node as when we reach parent thats when arr[id] == id
            // since in the code above we'd already set that  arr[root1] = root2;
            arr[id] = arr[arr[id]];
            id = arr[id];
        }
        return id;
    }
}