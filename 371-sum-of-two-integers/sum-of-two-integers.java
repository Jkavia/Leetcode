
// so we'll use ^ operator to do a+b but that would exclude carry 
// so we'll calculate carry seprately and add it in next iteration to overall sum
// and if that sum results in more carrys then we'll add them too in next iterations 
// until there are no more carrys to add and thats the final number then 
// in binary when we add 10 + 10 then the two 1s in same column becomes 0 and we carry that 1 to next column so 10+10 = 100
//(2+2 = 4) therefore we use <<1 to shift the carry appropriately to next bit. as 1&1 = 1 but we want one in next column
class Solution {
    public int getSum(int a, int b) {
        
        while(b != 0){
            int sum = a^b;
            int carry = (a&b) << 1;

            a = sum;
            b = carry;
        }
        return a;
    }
}