class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stck = new Stack<>();

        for(char c: s.toCharArray()){
            if(map.containsKey(c) && !stck.isEmpty()){
                if(stck.peek() != map.get(c)) return false;
                stck.pop();
            }else{
                stck.push(c);
            }
        }

        return stck.isEmpty();
    }
}