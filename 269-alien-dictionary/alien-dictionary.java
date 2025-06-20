class Solution {
    public String alienOrder(String[] words) {
        
        Map<Character, Set<Character>> charMap = new HashMap<>();
        // key is a character and value is all its dependencies i.e. words before it.
        Map<Character, Integer> dependenciesMap = new HashMap<>();
        for(int i=0;i<words.length;i++){
            for(char c: words[i].toCharArray()){
                if(!dependenciesMap.containsKey(c)){
                dependenciesMap.put(c,0);
            }
            }
        }
        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int len = Math.min(word1.length(), word2.length());

            if(word1.length()>word2.length() && word1.startsWith(word2))return "";

            for(int j=0;j<len;j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    Set<Character> neighbors = charMap.getOrDefault(word1.charAt(j), new HashSet<>());
                    if(!neighbors.contains(word2.charAt(j))){
                    neighbors.add(word2.charAt(j));
                    charMap.put(word1.charAt(j), neighbors);
                    dependenciesMap.put(word2.charAt(j),dependenciesMap.getOrDefault(word2.charAt(j),0)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> que = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
            for(Character c: dependenciesMap.keySet()){
                if(dependenciesMap.get(c) == 0){
                    que.add(c);
                }
            }

            while(!que.isEmpty()){
                char c = que.poll();
                sb.append(c);
                Set<Character> neighbors = charMap.get(c);
                if(neighbors == null || neighbors.isEmpty())continue;

                for(char chr: neighbors){
                    dependenciesMap.put(chr, dependenciesMap.get(chr)-1);
                    if(dependenciesMap.get(chr)==0){
                        que.add(chr);
                    }
                }
            }
            //if sb length doesnt contain all the characters that means we got a cycle. 
            if(sb.length() != dependenciesMap.size()){
                return "";
            }
            return sb.toString();
    }
}