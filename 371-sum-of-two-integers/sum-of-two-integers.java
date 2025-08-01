class Solution {
    public int getSum(int a, int b) {
        // add numbers without carry then add the carry 
        // repeat until there is no carry 

        while(b!=0){
            int sum = a^b;
            int carry = (a&b) << 1;

            a = sum;
            b = carry;
        }

        return a;
    }
}