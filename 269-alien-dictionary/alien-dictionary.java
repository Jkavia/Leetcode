class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> indegreeMap = new HashMap<>();
        Map<Character, Set<Character>> charMap = new HashMap<>();

        //add all words to indegree
        for(String word: words){
            for(char c: word.toCharArray()){
                if(!indegreeMap.containsKey(c)){
                    indegreeMap.put(c,0);
                }
            }
        }

        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.length() > word2.length() && word1.startsWith(word2))return "";

            int len = Math.min(word1.length(), word2.length());

            for(int j=0;j<len;j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    char c1 = word1.charAt(j);
                    char c2 = word2.charAt(j);
                    Set<Character> children = charMap.getOrDefault(c1, new HashSet<>());
                    if(!children.contains(c2)){
                    children.add(c2);
                    charMap.put(c1, children);
                    indegreeMap.put(c2, indegreeMap.get(c2)+1);
                    }
                    break;
                }
            }
        }

            //Now traverse this map in BFS using a que 
            Queue<Character> que = new LinkedList<>();
            for(char key: indegreeMap.keySet()){
                if(indegreeMap.get(key) == 0){
                    que.add(key);
                }
            }

            StringBuffer sb = new StringBuffer();
            while(!que.isEmpty()){
                char curr = que.poll();
  
                sb.append(curr);
                Set<Character> children = charMap.get(curr);
                if(children == null || children.isEmpty())continue;

                for(char c: children){
                    indegreeMap.put(c, indegreeMap.get(c)-1);
                    if(indegreeMap.get(c) == 0){
                        que.add(c);
                    }
                }
            }
  
        return (sb.length() == indegreeMap.size()) ? sb.toString():"";
    }
}

// create a map of indegree 
// parse thorough words in pairs of two and whenever there is a mismatch add word1 char as key and word 2 char as value to set 
// ["wrt","wrf","er","ett","rftt"]
/****

w 0
r 0
t 0
f 0
e 0

t f
w e
r t
e r
sb = wertf
que = f

f
make e indegree -1
if that makes it 0, add to que

 */