// run through the array and add all the words that starts with the substring to the PQ
// run a while loop on PQ and get all the elements upto size 3 of list. 
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> retlist = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>();

        for(int i=1;i<=searchWord.length();i++){
            String subStr = searchWord.substring(0,i);
            for(String product: products){
                if(product.startsWith(subStr)){
                    pq.add(product);
                }
            }

            List<String> temp = new ArrayList<>();
            while(!pq.isEmpty()){
                temp.add(pq.poll());
                if(temp.size() == 3)break;
            }
            pq.clear();
            retlist.add(temp);
        }
        
        return retlist;
    }
}