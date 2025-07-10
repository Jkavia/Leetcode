// first we will run a for loop on the matrix and whenever we find a 1
// we will run a dfs on it and while running dfs we will maintain a count 
// and increment is accordingly but at the same time we will also 
// updates all the cells belonging to that island with id of that island 

// now in next call since all the adjacent 1's are reassigned island id so we'll only call
// next dfs on non-connected island land set and id to it and run the dfs and return the area

// once we get the area of each of these islands we also save it in a list and the list 
// corresponds to list index for that island will be "island id-2"(since we start with id 2 i.e. 0 index for list )


// once we have this list of all islands with their individual id and areas, we'll run another loop 
// and check for 0's and we'll try to see of that 0 has any island neighbors and we'll add those to sum and compare it with max, and then re-do the same for another 0. 
// we also need to maintain a visited set so that if some island is surrounding 0 on 2 or 3 
// sides we dont count it again and again as a new neighbor island. 




class Solution {
    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int maxSum = Integer.MIN_VALUE;
        int id = 2; // since 0 and 1 is already used
        List<Integer> areas = new ArrayList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    int sum = dfs(i,j,id,grid,directions);
                    areas.add(sum);
                    id++;
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 0){
                    Set<Integer> visited = new HashSet<>();
                    int sum = 1;
                    for(int[] dir:directions){
                        int x = i+dir[0];
                        int y = j+dir[1];
                        if(x>=0 && x<row && y>=0 && y<col && grid[x][y]!=0 && !visited.contains(grid[x][y])){
                            int isLandId = grid[x][y];
                            sum += areas.get(isLandId-2);
                            visited.add(isLandId);
                        }
                    }
                    maxSum = Math.max(maxSum,sum);
                }
            }
        }

        return maxSum == Integer.MIN_VALUE ? row*col : maxSum;
    }

    public int dfs(int row, int col, int id, int[][] grid, int[][] directions){

        if(row<0 || row>= grid.length || col<0 || col>=grid[0].length || grid[row][col]!=1){
            return 0;
        }

        grid[row][col] = id;

        int count =1;

        for(int[] dir:directions){
            int x = dir[0]+row;
            int y = dir[1]+col;

            count += dfs(x,y,id,grid,directions);
        }

        return count;
    } 
}