// have a map 
// iterate thorugh the s, and check for every p elements at a time 
// if match add

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        System.out.println(slen +"  "+plen);
        Map<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int count =0;
        List<Integer> ret = new ArrayList<>();
        
        //sliding window 
        int l=0, r=0;

        while(r<=slen){
            //System.out.println(count);
            if(r-l == plen){
                
                if(count == map.size()){
                    ret.add(l);
                }
                char c = s.charAt(l);
                if(map.containsKey(c)){
                    if(map.get(c) == 0)count--;
                    map.put(c, map.get(c)+1);
                }
                l++;
            }
            if(r == slen)break;
            char curr = s.charAt(r);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr)-1);
                if(map.get(curr) == 0)count++;
            }
            r++;
        }

        return ret;
    }
}