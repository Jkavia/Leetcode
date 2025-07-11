class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            int currHeight = heights[i];
            int count =0;
            while(!stack.isEmpty() && stack.peek()<currHeight){
                count++;
                stack.pop();
            }

            int updatedCount = count + ((stack.isEmpty())?0:1);
            heights[i] = updatedCount;
            stack.push(currHeight);
        }

        return heights;
    }
}
// Alternative solution using stacks
// start from right to left 
// at each element check if the top element in stack is smaller than this element 
// if yes then increase count and pop that element out and check again, repeat the process
// until stack is empty or an element greater than current element is found. 
// now we would put that count as the number of the elements that are seeable from current element
// we'll have another check to just add the count for the larger element which is still in stack 
// so if stack is non empty we just add 1 
// and then just push the current element in the stack.

// we remove the smaller elements from the stack because if you see right to left from 
// element i to j then if i+1 > i+2 then at i we wont see i+2 anyway hence we removed it 

// Approach two
// track currMax 0 
// if ith height is > currMax then count++ & if not skip 
// break the loop when height is >= own height;