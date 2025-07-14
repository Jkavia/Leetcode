class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int curr =0;

        for(char c:s.toCharArray()){
            if(c == '('){
                curr++;
            }
            if(c == ')'){
                max = Math.max(curr, max);
                curr--;
            }
        }
        return max;
        
    }
}