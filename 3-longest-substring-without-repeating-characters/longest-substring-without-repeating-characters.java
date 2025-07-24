class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l=0,r=0;
        int max =0;

        while(r < s.length()){
            char curr = s.charAt(r);
            map.put(curr, map.getOrDefault(curr, 0)+1);
            max = Math.max(max, r-l);
            while(map.get(curr)>1){
                char lcurr = s.charAt(l);
                map.put(lcurr, map.get(lcurr)-1);
                l++;
            }
            r++;
        }

        return Math.max(max,r-l);
    }
}