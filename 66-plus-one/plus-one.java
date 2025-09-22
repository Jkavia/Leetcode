class Solution {
    public int[] plusOne(int[] digits) {
        int carry =1;
        int count =0;
        for(int digit:digits){
            if(digit == 9)count++;
        }
        int[] ret;
        if(count == digits.length){
            ret = new int[digits.length+1];
        }else{
            ret = new int[digits.length];
        }

        for(int i=digits.length-1;i>=0;i--){
            int currTotal = digits[i]+carry;
            int numToAdd = currTotal%10;
            //System.out.println(numToAdd);
            ret[i] = numToAdd;
            if(currTotal>=10){
                carry =1;
            }else{
                carry=0;
            }
        }
        if(carry == 1){ret[0] =1;}

        return ret;
    }
}