class Solution {
    public int countSubstrings(String s) {
        int ret =0;

        for(int i=0;i<s.length();i++){
            ret+= ispalin(s, i, i);
            ret+= ispalin(s, i, i+1);
        }

        return ret;
    }

    public int ispalin(String s, int i, int j){
        int count =0;

        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            count++;
        }

        return count;
    }
}

// instead of outside in char comparisons 
// we do inside out and there are only two possiblities either odd length 
// and even length strings, 