class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put(')','(');
        charMap.put('}','{');
        charMap.put(']','[');

        Stack<Character> stk = new Stack<>();

        for (char c: s.toCharArray()){

            if(charMap.containsKey(c)){

                if(stk.isEmpty() || charMap.get(c)!= stk.peek()){
                    return false;
                }
                stk.pop();

            }else{
                stk.push(c);
            }
        }
        return stk.isEmpty();

        
    }
}