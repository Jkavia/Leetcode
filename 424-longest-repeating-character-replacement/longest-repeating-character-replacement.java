class Solution {
    public int characterReplacement(String s, int k) {
        int maxCount =0;

        for(char i='A';i<='Z';i++){
            int l=0,r=0,replacement =0;
            while(r<s.length()){
                char end = s.charAt(r);
            

                if(end == i){
                    r++;
                }else if(replacement < k){
                    r++;
                    replacement++;
                }else if(s.charAt(l) == i){
                    l++;
                }else{
                    l++;
                    replacement--;
                }

                maxCount = Math.max(maxCount, r-l);
            }
        }

        return maxCount;
    }
}

// so bascially maintain a sliding window and then as you move the window
// update the count of replacements accordingly 