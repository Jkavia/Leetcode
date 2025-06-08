class Solution {
    // Center expansion method 
    public String longestPalindrome(String s) {
        int n = s.length();
        int end =0;
        int start =0;

        for(int i=0;i<s.length();i++){
            int len1 = isPalin(s,i,i);
            int len2 = isPalin(s,i,i+1);
            int finLen = Math.max(len1, len2);
            if(finLen > end-start){
                start = i - (finLen-1)/2;
                end = i + finLen/2;
            }
        }
        return s.substring(start, end+1);
    }
    // Center expansion
    private int isPalin(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return r-l-1;
    }
}