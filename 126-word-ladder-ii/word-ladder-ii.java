class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //we need to do a breath first search here, so we'll start from the begin word in a queue
        // then we'll find all its adjacent neighbors that are 1 letter shift. 
        // we store this in a adjacency matrix in reverse fashion <neighbor, inputWord>
        // we will also store this in a temporary set to maintain the next layer of bfs traversal
        // while traversing if we do end up finding our target word we'll break the loop as we dont worry about path beyond that. 
        // we'll also register this event as a flag to know for sure that we can reach upto the target word.

        //Next to compare since the lengths of word is same we'll to char by char comparison between two strings and return boolean
        // Lastly, to create a path we'll do a dfs search and we start from last node and traverse all the way upto the first.

        List<List<String>> res = new ArrayList<>();
        Queue<String> que = new LinkedList<>();
        Set<String> unvisited = new HashSet<>(wordList);
        que.add(beginWord);
        Map<String, Set<String>> similarWordsMap = new HashMap<>();
        Set<String> visited = new HashSet<>();
        boolean foundIt = false; 

        while (!que.isEmpty()){
            String word = que.poll();
            for(String currWord:unvisited){
                if(isSimilar(word, currWord)){
                    visited.add(currWord);
                    Set<String> neighbors = similarWordsMap.getOrDefault(currWord, new HashSet<>());
                    neighbors.add(word);
                    similarWordsMap.put(currWord, neighbors);

                    if(currWord.equals(endWord)){
                        foundIt = true;
                        break;
                    }
                }
            }

            if(que.isEmpty()){
                que.addAll(visited);
                unvisited.removeAll(visited);
                visited.clear();
            }
        }

        if(!foundIt)return res;
        List<String> path = new ArrayList<>();
        path.add(endWord);
        findPath(endWord, beginWord, path, res, similarWordsMap);

        return res;
    }


    public void findPath(String endWord, String beginWord, List<String> path, List<List<String>> res, Map<String, Set<String>> similarWordsMap){
        Set<String> adjacents = similarWordsMap.get(endWord);
        if(adjacents == null)return;
        for( String word: adjacents){
            path.add(word);
            if(word.equals(beginWord)){
                List<String> newPath = new ArrayList<>(path);
                Collections.reverse(newPath);
                res.add(newPath);
            }else{
                findPath(word, beginWord, path, res, similarWordsMap);
            }
            path.remove(word);
        }
    }


    public boolean isSimilar(String word, String currWord){
        int count=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)!= currWord.charAt(i)){
                count++;
            }
        }
        return count==1;
    }
}