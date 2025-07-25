class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int plen = p.length();
        int slen = s.length();
        char[] carr = p.toCharArray();
        Arrays.sort(carr);
        String sorted = new String(carr);
        List<Integer> ret = new ArrayList<>();
        
        for(int i=0;i<=slen-plen;i++){
            String str = s.substring(i, i+plen);
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String updated = new String(arr);
            if(updated.equals(sorted)){
                ret.add(i);
            }
        }
        return ret;
    }
}