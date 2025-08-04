class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] ids = new int[n];
        for(int i=0;i<n;i++)ids[i] =i;

        for(int[] edge:edges){
            int root1 = union(edge[0],ids);
            int root2 = union(edge[1], ids);

            if(root1 != root2){
                ids[root1] = root2;
                n--;
            }
        }
        return n;
    }

    public int union(int id, int[] arr){

        while(arr[id] != id){
            arr[id] = arr[arr[id]];
            id = arr[id];
        }
        return id;
    }
}

// can be solved using union find also 
// where we mark the visited node with the parents id 