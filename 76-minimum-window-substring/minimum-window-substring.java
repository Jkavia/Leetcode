class Solution {
    public String minWindow(String str, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        int s = 0, e =0;
        int a1=0,a2=str.length()+1;

        while(e < str.length()){
            char end = str.charAt(e);
            if(map.containsKey(end)){
                map.put(end, map.get(end)-1);
                if(map.get(end) == 0)count--;
            }

            while(count == 0){
                if(a2-a1 > e-s){
                    a1 = s;
                    a2 = e;
                }

                char start = str.charAt(s);
                if(map.containsKey(start)){
                    map.put(start, map.get(start)+1);
                    if(map.get(start) > 0)count++;
                }
                s++;
            }
            e++;
        }

        return (a2 == str.length()+1)?"":str.substring(a1, a2+1);
    }
}
