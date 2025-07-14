class Solution {
    public int maxDepth(String s) {
        Stack<Character> stck = new Stack<>();
        int maxDepth = 0;
        for(char c:s.toCharArray()){
            if(c == '('){
                stck.push(c);
                maxDepth = Math.max(maxDepth, stck.size());
            }

            if(c == ')'){
                stck.pop();
            }
        }

        return maxDepth;
        
    }
}