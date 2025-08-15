class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> indegreeMap = new HashMap<>();
        Map<Character, Set<Character>> charMap = new HashMap<>();

        for(String word: words){
            for(char c: word.toCharArray()){
                indegreeMap.put(c,0);
            }
        }


        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];

            if(w1.length() > w2.length() && w1.startsWith(w2))return "";

            int len = Math.min(w1.length(), w2.length());

            for(int j=0;j<len;j++){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if(c1 != c2){
                    if(charMap.get(c1) == null){
                        charMap.put(c1, new HashSet<>());
                    }
                    Set<Character> children = charMap.get(c1);
                    if(!children.contains(c2)){
                        children.add(c2);
                        charMap.put(c1,children);
                        indegreeMap.put(c2, indegreeMap.get(c2)+1);
                    }
                    break;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        Queue<Character> que = new LinkedList<>();
        for(char key: indegreeMap.keySet()){
            if(indegreeMap.get(key) == 0){
                que.add(key);
            }
        }

        while(!que.isEmpty()){
            char curr = que.poll();
            sb.append(curr);

            if(charMap.get(curr) == null || charMap.get(curr).isEmpty())continue;

            for(char c: charMap.get(curr)){
                indegreeMap.put(c, indegreeMap.get(c)-1);
                if(indegreeMap.get(c) == 0){
                    que.add(c);
                }
            }
        }

        return (sb.length() == indegreeMap.size())? sb.toString():"";
    }
}