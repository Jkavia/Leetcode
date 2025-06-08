class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
             char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String temps = new String(arr);
            if(map.containsKey(temps)){
                map.get(temps).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(temps,list);
            }
        }

        return new ArrayList<>(map.values());

        // Space complexity N unique strings with K anagram for each so O(N*K)
        
    }
}