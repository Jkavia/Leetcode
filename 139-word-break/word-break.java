class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> dp = new HashMap<>();
        return checkRecurse(s,0,wordDict,dp);
        
    }


    public boolean checkRecurse(String s,int curr, List<String> wordDict,Map<Integer, Boolean> dp){
        if(dp.containsKey(curr)){
            return dp.get(curr);
        }
        if(s.length() == curr){
            return true;
        }

        boolean ret = false;

        for(String str: wordDict){
            if(s.indexOf(str,curr) == curr){
                ret = checkRecurse(s, curr+str.length(),wordDict,dp);
                if(ret)break;
            }
        }
        dp.put(curr, ret);
        return ret;
    }
}