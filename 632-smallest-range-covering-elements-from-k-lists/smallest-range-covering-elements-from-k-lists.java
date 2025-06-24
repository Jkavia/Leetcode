class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            int[] entry = new int[]{nums.get(i).get(0), i,0};
            minHeap.add(entry);
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }

        int[] ret = new int[]{0, Integer.MAX_VALUE};

        while(true){
            int[] entry = minHeap.poll();
            int minVal = entry[0];
            int listIdx = entry[1];
            int valIdx = entry[2];
            // if this window is smaller than existing one , then replace
            if(maxValue-minVal < ret[1]-ret[0]){
                ret[0] = minVal;
                ret[1] = maxValue;
            }

            if(nums.get(listIdx).size()-1 > valIdx){
                //System.out.println(" listIdx"+listIdx+" valIdx"+valIdx);
            int nextVal = nums.get(listIdx).get(valIdx+1);
            int[] newEntry = new int[]{nextVal, listIdx,valIdx+1};
            minHeap.add(newEntry);
            maxValue = Math.max(maxValue, nextVal);
            }else{
                //we've reached to end of one of the lists so we exit
                break;
            }
        }

        return ret;
    }
}