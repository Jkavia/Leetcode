class Solution {
    public boolean isPalindrome(String s) {
        String updated = s.replaceAll("[^a-zA-Z0-9]", "");
        String lowered = updated.toLowerCase();
        int i=0, j=lowered.length()-1;
        while(i<j){
            if(lowered.charAt(i) != lowered.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}