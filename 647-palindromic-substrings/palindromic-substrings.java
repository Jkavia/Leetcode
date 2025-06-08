class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for(int i=0;i<s.length();i++){
            int len1 = ispalin(s,i,i);
            int len2 = ispalin(s,i,i+1);
            count += len1+len2;
        }

        return count;
    }

    private int ispalin(String s, int i, int j){

        int count = 0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
}