class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(target == source) return 0;
        int maxVal = 0;
        Map<Integer, Set<Integer>> hm = new HashMap<>();

        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                int key = routes[i][j];
                maxVal = Math.max(maxVal, key);
                Set<Integer> tempSet;
                if(hm.containsKey(key)){
                    tempSet = hm.get(key);
                }else{
                    tempSet = new HashSet<>();
                }
                tempSet.add(i);
                hm.put(key, tempSet);
            }
        }

        if(target > maxVal || source > maxVal) return -1;


        int count =0;
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> seenRoute = new HashSet<>();

        que.add(source);
        while(!que.isEmpty()){
            count++;
            int size = que.size();
            for(int i=0;i<size;i++){
                int key = que.poll();
                System.out.println(key);
                Set<Integer> addedRoutes = hm.get(key);

                for(Integer route:addedRoutes){
                    if(seenRoute.add(route)){
                        int[] stopsOnThatRoute = routes[route];

                        for(int stop:stopsOnThatRoute){
                            if(stop == target) return count;
                            que.add(stop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}