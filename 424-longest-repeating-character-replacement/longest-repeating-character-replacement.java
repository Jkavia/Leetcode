class Solution {
    public int characterReplacement(String s, int k) {
        int maxCount = 0;

        for(char c = 'A';c<='Z';c++){
            int l=0,r=0,replacements=0;
            while(r<s.length()){
                if(s.charAt(r) == c){
                    r++;
                }else if(replacements < k){
                    replacements++;
                    r++;
                }else if(s.charAt(l) == c){
                    l++;
                }else{
                    l++;
                    replacements--;
                }
                maxCount = Math.max(maxCount, r-l);
            }
        }

        return maxCount;
    }
}

// here we'll use sliding window for each of the alphabet in the vocabulary 
// and as we move we'll track the count of the alphabet and k
// we'll ajust the k as we shrink the window 