class Solution {
    public int hammingWeight(int n) {
        //keep moving bits one spot at a time until all bits are moved and number left is 0, 
        // while moving the bits check at each step is the last bit is 1 by doing & 1 and add it to count
        int count = 0;
        while (n > 0){
            count += n&1;
            n = n>>>1;
        }
        return count;
    }
}