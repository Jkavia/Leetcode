class Solution {
    public int getSum(int a, int b) {

        while(b!=0){
            int sum = a^b;
            int carry = (a&b) << 1;

            a = sum;
            b = carry;
        }   

        return a;
        
    }
}

// we'll do a^b to add them but that doesnt include the carry so we'll do a&b << 1 to account for it