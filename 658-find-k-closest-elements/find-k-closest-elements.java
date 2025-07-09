// populate priortiy queue with elements unit size is k
// once we reach k, the order of elelments in queue is smallest element first. 
// now if we add a new elelemtn whose difference is smaller than the diffrence 
// with smallest element in that range then we will shift the range to right side element 
// and remove that smallest num from que. 

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int a:arr){
            if(pq.size()<k){
                pq.add(a);
            }else if(Math.abs(pq.peek()-x) > Math.abs(a-x)){
                pq.poll();
                pq.add(a);
            }
        }

        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        return list;
    }
}

// time complexity of the current approach is NlogK worse case, to improve that 
// we can do a binary search of the range. such that if the mid-x < mid+k-x we move the right ptr to mid
// or vice versa. and in that case our complexity will go down to log N
// pseudo code
// left = 0, right = len-k
// while(left<right)
//    mid = left +(left-right)/2;
//    if(Math.abs(arr[mid]-x) > Math.abs(arr[mid+k]-x))left = mid+1
//    else right = mid
//     then run the loop from left to k and add elements. 