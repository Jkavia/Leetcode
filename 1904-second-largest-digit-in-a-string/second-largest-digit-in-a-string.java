class Solution {
    public int secondHighest(String s) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = -1;

        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                int val = Character.getNumericValue(c);
                if(largest == Integer.MIN_VALUE){
                    largest = val;
                    continue;
                } 
                if(val>largest){
                    secondLargest = largest;
                    largest = val;
                }else if(val>secondLargest && val<largest){
                    secondLargest = val;
                }
            }
        }

        return secondLargest;
    }
}