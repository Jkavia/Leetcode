class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Other way is to skip sorting the array and instead use a PQ or treeSet and 
        // fix its length to no more than 3, that way it will auto sort as we add
        // and sorting complexity will be log(3) so constant. 

        List<List<String>> retlist = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>();

        for(int i=1;i<=searchWord.length();i++){
            String currWord = searchWord.substring(0,i);

            for(String product:products){
                if(product.startsWith(currWord)){
                    set.add(product);
                    if(set.size()>3)set.pollLast();
                }
            }
            List<String> currList = new ArrayList<>(set);
            retlist.add(currList);
            set.clear();
        }

        return retlist;
    }
}