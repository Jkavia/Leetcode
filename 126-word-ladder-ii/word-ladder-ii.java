class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> allPaths = new ArrayList<>();
        if(beginWord.equals(endWord))return allPaths;
        //have the begin word in the queue
        // compare the current queue word with all words from set and if 
        //char difference is only 1 return true;
        // if there is a match put that word in next layer of queue and also reverse adjacency map. 
        //Maintain a wordset that contains all the words
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> que = new LinkedList<>();
        que.add(beginWord);

        //Maintain a list of all the words that are 1 letter away from current word
        Set<String> similarWords = new HashSet<>();

        //Maintain a adjacency list of one char diff words in reverse order. 
        Map<String, Set<String>> adjacencyMap = new HashMap<>();

        //Maintain the track of the fact that we can actually reach the endWord
        boolean wasEndReached = false;

        //parse que in bfs manner. 

        while(!que.isEmpty()){
            String currWord = que.poll();

            //run a loop of all the unvisted words to check for 1 char diff 
            for(String word:wordSet){
                //check if its similar at 1 char diff
                if(isOneCharAway(currWord, word)){
                    //add it to the similar words list 
                    similarWords.add(word);
                    // add it to the adjacency map 
                    Set<String> neighbors = adjacencyMap.getOrDefault(word, new HashSet<>());
                    neighbors.add(currWord);
                    adjacencyMap.put(word,neighbors);
                    //also check if at any point we found the endWord then we can set the flag
                    if(word.equals(endWord)){
                        wasEndReached = true;
                    }
                }
            }

            //once all the values of queue are parsed at this layer 
            if(que.isEmpty()){
                //if end was already found we can exit the loop
                if(wasEndReached)break;
                //remove the visited nodes from overall list of wordset
                wordSet.removeAll(similarWords);
                //add these words to next layer of bfs 
                que.addAll(similarWords);
                // clear the similarWords for next iteration 
                similarWords.clear();
            }
        }

        //return an empty list if we were not able to find a path to end word
        if(!wasEndReached) return allPaths;
        Set<String> path = new LinkedHashSet<>();
        path.add(endWord);
        findPaths(endWord, beginWord, adjacencyMap, allPaths, path);

        return allPaths;
    }

    // Method to do a dfs to find all possible paths to target. 
    public void findPaths(String word, String target, Map<String, Set<String>> adjacencyMap,
     List<List<String>> allPaths,  Set<String> path){
        
        Set<String> similarWords = adjacencyMap.get(word);
        
        if(similarWords == null) return;
        
        for(String sWord: similarWords){
            
            path.add(sWord);
            
            if(sWord.equals(target)){
                List<String> shortestPath = new ArrayList<>(path);
                Collections.reverse(shortestPath);
                allPaths.add(shortestPath);
            }else{
                findPaths(sWord, target, adjacencyMap, allPaths, path);
            }
            path.remove(sWord);
        }
     }

    public boolean isOneCharAway(String currWord, String word){
       int totalDiff =0;

       for(int i=0;i<currWord.length();i++){
        if(currWord.charAt(i)!= word.charAt(i))totalDiff++;
       } 

       return totalDiff==1;

    }

}