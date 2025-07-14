class Solution {
    public int maxDepth(String s) {
        int open =0;
        int maxDepth = 0;
        for(char c:s.toCharArray()){
            if(c == '('){
                open++;
                maxDepth = Math.max(maxDepth, open);
            }

            if(c == ')'){
                open--;
            }
        }

        return maxDepth;
        
    }
}