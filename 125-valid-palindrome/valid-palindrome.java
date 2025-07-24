class Solution {
    public boolean isPalindrome(String s) {
        String updated = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int l=0,r=updated.length()-1;
        
        while(l<r){
            if(updated.charAt(l)!= updated.charAt(r))return false;
            l++;
            r--;
        }

        return true;
    }
}