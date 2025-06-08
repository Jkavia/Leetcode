class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')return 0;

        int curr =0;
        int prev = 1;
        int preprev = 1;

        for(int i=2;i<=s.length();i++){
            curr = 0;
            char c = s.charAt(i-1);
            int num = Character.getNumericValue(c);

            if(num >0 && num<10){
                curr += prev;
            }
            String lastTwodigsNum = s.substring(i-2, i);
            int val = Integer.parseInt(lastTwodigsNum);

            if(val >= 10 && val <=26){

                curr += preprev;
            }
                preprev = prev;
                prev = curr;
            }
                    return s.length()<2?prev:curr;
        }
        
    }