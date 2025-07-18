class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] adjMap = new List[numCourses];
        Queue<Integer> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int[] cell:prerequisites){
            int course = cell[0];
            int prereq = cell[1];

            if(adjMap[prereq] == null){
                adjMap[prereq] = new ArrayList<>();
            }
            adjMap[prereq].add(course);
            indegree[course]++;
        }

        for(int node =0; node<indegree.length;node++){
            if(indegree[node] == 0)que.add(node);
        }

        while(!que.isEmpty()){
            int parentCourse = que.poll();
             ans.add(parentCourse);

            if(adjMap[parentCourse] != null){
                for(int childCourse: adjMap[parentCourse]){
                    indegree[childCourse]--;
                    if(indegree[childCourse] == 0){
                        que.add(childCourse);
                    }
                }
            }
        }

        return ans.size() == numCourses;

    }
}


//1 -> 4 ->   5
//     |      |
//        <--
//now when 1 is picked up the indegree of 4 gets reduced by 1, 
//but since it has a cycle from the element that is ahead of it that's made its 
//indegree 2, but it can never we reached until we get past this element.
//therefore its impossible to take all the courses. 