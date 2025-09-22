class Solution {
    public int[] plusOne(int[] digits) {
        int carry =1;
        Stack<Integer> stck = new Stack<>();

        for(int i=digits.length-1;i>=0;i--){
            int currTotal = digits[i]+carry;
            int numToAdd = currTotal%10;
            //System.out.println(numToAdd);
            stck.push(numToAdd);
            if(currTotal>=10){
                carry =1;
            }else{
                carry=0;
            }
        }
        if(carry == 1){stck.push(1);}
        int[] ret = new int[stck.size()];
        int idx =0;
        while(!stck.isEmpty()){
            int val = stck.pop();
            ret[idx++] = val;
        }

        return ret;
    }
}