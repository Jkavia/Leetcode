class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> list = new ArrayList<>();

        for(int i=0;i<profit.length;i++){
            list.add(new int[]{profit[i], difficulty[i]});
        }

        Collections.sort(list, (a,b) -> Integer.compare(b[0],a[0]));

        int totalMax =0;
        for(int w: worker){
            int currMax = 0;
            for(int[] arr: list){
                if(arr[1]<= w){
                    currMax = arr[0];
                    break;
                }
            }
            totalMax += currMax;
        }

        return totalMax;
    }
}

//[{50, 10}, {}]