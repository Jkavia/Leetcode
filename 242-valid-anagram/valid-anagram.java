class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        int count =0;
        for(char c: s.toCharArray()) charMap.put(c, charMap.getOrDefault(c,0)+1);

        for(char c: t.toCharArray()){
            if(charMap.containsKey(c) && charMap.get(c)>0){
                charMap.put(c, charMap.get(c)-1);
                count++;
            }else{
                return false;
            }
        }
        return (count == s.length());
    }
}