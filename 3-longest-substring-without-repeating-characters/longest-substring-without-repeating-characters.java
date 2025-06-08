class Solution {
    public int lengthOfLongestSubstring(String s) {

        int p1=0,p2=0;
        Map<Character, Integer> charCount = new HashMap<>();
        int maxLen = 0;

        while(p2< s.length()){
            char c = s.charAt(p2);
            maxLen = Math.max(maxLen, p2-p1);
            if(charCount.containsKey(c) && charCount.get(c)>0){
                while(p1<s.length() && charCount.get(c)>0){
                    char start = s.charAt(p1);
                    int updatedVal = charCount.get(start)-1;
                    charCount.put(start,updatedVal);
                    p1++;
                }
            }
            charCount.put(c,charCount.getOrDefault(c,0)+1);
            p2++;
        }
        return Math.max(maxLen, p2-p1);
    }
}