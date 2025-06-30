class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int size = map.size();
        int count =0;
        int[] coordinates = new int[]{0, s.length()-1};
        int minLen = Integer.MAX_VALUE;
        int start =0, end =0;

        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                //System.out.println("before: "+c+"   "+map.get(c));
                if(map.get(c) == 0)count++;
            }
            end++;
            while(start < s.length() && count == size){
                //System.out.println(start+"   "+end);
                if(minLen > end-start){
                    minLen = end-start;
                    coordinates[0] = start;
                    coordinates[1] = end;
                }
                char sChar = s.charAt(start);
                if(map.containsKey(sChar)){
                map.put(sChar, map.get(sChar)+1);
                //System.out.println("afterUp: "+sChar+"   "+map.get(sChar));
                if(map.get(sChar) > 0){
                    //System.out.println("after: "+sChar+"   "+map.get(sChar));
                    count--;}
                }
                start++;
            }   
        }
        if(minLen == Integer.MAX_VALUE)return "";
        return s.substring(coordinates[0],coordinates[1]);
        }
        
    }