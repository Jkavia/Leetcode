class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stck = new Stack<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                if(stck.isEmpty() || stck.peek() != map.get(c))return false;
                stck.pop();
            }else{
                stck.push(c);
            }
        }
        return stck.isEmpty();

    }
}