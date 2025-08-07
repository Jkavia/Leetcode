class Solution {
    public int countSubstrings(String s) {
        int n= s.length();
        int ret = 0;


        for(int i=0;i<n;i++){
            ret += palin(i,i, s);
            ret += palin(i, i+1, s);
        }

        return ret;
    }

    public int palin(int i, int j, String s){
        int count =0;

        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }

        return count;
    }
}

// there are only two types of palindromes 
// even length and odd len
// we'll compare both and do inside out comparison 
// starting from i=0 to n-1