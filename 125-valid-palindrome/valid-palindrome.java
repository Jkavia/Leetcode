class Solution {
    public boolean isPalindrome(String s) {
        String newString = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int l=0,r=newString.length()-1;

        while(l<r){
           if(newString.charAt(l)!=newString.charAt(r)){
            return false;
           }
            l++;
            r--;
        }
        return true;
    }
}