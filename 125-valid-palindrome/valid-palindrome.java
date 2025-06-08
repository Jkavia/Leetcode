class Solution {
    public boolean isPalindrome(String s) {
        String stripped = s.replaceAll("[^a-zA-Z0-9]","");
        String lowecase = stripped.toLowerCase();
        int l =0, r = lowecase.length()-1;
        while(l<=r){
            if(lowecase.charAt(l) != lowecase.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}