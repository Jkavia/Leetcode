class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> openingStyle = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        openingStyle.addAll(Arrays.asList('(','[','{'));

        for(char c:s.toCharArray()){
            if(openingStyle.contains(c)){
                stack.push(c);
            }else{
                char closingchar = map.get(c);
                if(!stack.isEmpty() && stack.peek() == closingchar){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();

        
    }
}

// use map to track the closing bracket char for each opening type. 
// use stack to store the opening brackets. 
// and whenever you see a closing bracket you should check if the bracket against it in map is 
// the top element in stack, if true pop stack element 
// if stack is null or there is a mismatch return false. 