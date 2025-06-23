class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> charMap = new HashMap<>();
        for(char c:t.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c,0)+1);
        }
        int count = charMap.size();
        int start = 0, minlen = Integer.MAX_VALUE;
        int p1=0,p2=0, slen = s.length();

        while(p2 < slen){
            char cr = s.charAt(p2);
            if(charMap.containsKey(cr)){
                charMap.put(cr, charMap.get(cr)-1);
                if(charMap.get(cr)==0)count--;
            }
            p2++;
            while(count ==0 && p1<=p2){
                    if(p2-p1 < minlen){
                        start = p1;
                        minlen = p2-p1;
                    }
                    char temp = s.charAt(p1);
                    p1++;
                    if(charMap.containsKey(temp)){
                        charMap.put(temp, charMap.get(temp)+1);
                        if(charMap.get(temp)>0)count++;

                    }
            }
        }

         if(minlen == Integer.MAX_VALUE)return "";

        return s.substring(start, start+minlen);
        
        
    }
}