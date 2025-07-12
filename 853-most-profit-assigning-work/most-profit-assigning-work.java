class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> maxProfitForDifficulty = new ArrayList<>();

        for(int i=0;i<difficulty.length;i++){
            maxProfitForDifficulty.add(new int[]{difficulty[i], profit[i]});
        }

        maxProfitForDifficulty.sort((a,b)-> Integer.compare(a[0], b[0]));

        int maxProfit = 0;

        for(int[] arr:maxProfitForDifficulty){
            maxProfit = Math.max(maxProfit, arr[1]);
            arr[1] = maxProfit;
        }

        int totalProfit =0;
        for(int w:worker){
            int idx = binarySearch(maxProfitForDifficulty,w);
            totalProfit += idx;
        }

        return totalProfit;
    }


    public int binarySearch(List<int[]> maxProfitForDifficulty, int w){
        int r = maxProfitForDifficulty.size()-1;
        int l = 0;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(maxProfitForDifficulty.get(mid)[0] > w){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        System.out.println(w+". "+r);

        return (r == -1)?0:maxProfitForDifficulty.get(r)[1];
    }
}


// we will first create a list with difficulty and profits and then sort it by difficulty
// next we will parse the list and track the maximum profit for that difficulty 
// and update the val with that max profit. 
// then we'll do a binary search on this difficulty list which closest match to the worker 
// and return that max profit. 
// we'll keep adding this max profit for each worker to overall profit and then return it