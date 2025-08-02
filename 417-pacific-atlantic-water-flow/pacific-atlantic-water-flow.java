// left and right side dfs 
// top and bottom dfs 
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] visistedPacific = new boolean[m][n];
        boolean[][] visistedAtlantic = new boolean[m][n];

        // left and right edges dfs
        for(int i=0;i<m;i++){
            dfs(i,0,visistedPacific, heights);
            dfs(i, n-1,visistedAtlantic, heights);
        }

        // top and bottom edges dfs
        for(int j=0;j<n;j++){
            dfs(0,j,visistedPacific, heights);
            dfs(m-1,j,visistedAtlantic, heights);
        }
        List<List<Integer>> ret = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visistedPacific[i][j] && visistedAtlantic[i][j]){
                    ret.add(Arrays.asList(i,j));
                }
            }
        }

        return ret; 
    }

    public void dfs(int x, int y, boolean[][] visited, int[][] heights){
        int m = visited.length;
        int n = visited[0].length;
        visited[x][y] = true;

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        for(int[] dir: dirs){
            int i = x+dir[0];
            int j = y+dir[1];

            if(i>=0 && i<m && j>=0 && j<n && !visited[i][j] && heights[x][y]<=heights[i][j]){
                dfs(i,j,visited, heights);
            }
        }
        }
}