class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longest =0;
        int l=0, r = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c,0)+1);
            //System.out.println(l+"  "+r);
            longest = Math.max(longest, r-l);
            while(map.get(c)>1){
                char frst = s.charAt(l);
                map.put(frst, map.get(frst)-1);
                l++;
            }
            r++;
        }

        longest = Math.max(longest, r-l);

        return longest;
        
    }
}