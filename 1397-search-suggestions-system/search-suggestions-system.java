class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        //brute force method just pick first letter of search word look up
        // then pick first two letters look up and so on. 

        List<List<String>> retlist = new ArrayList<>();
        Arrays.sort(products);
        for(int i=1;i<=searchWord.length();i++){
            String currWord = searchWord.substring(0,i);
            List<String> currLayerList = new ArrayList<>();
            for(String product:products){
                if(product.startsWith(currWord)){
                    currLayerList.add(product);
                }
                if(currLayerList.size() == 3)break;
            }
                retlist.add(currLayerList);
        }
        return retlist;
    }
}