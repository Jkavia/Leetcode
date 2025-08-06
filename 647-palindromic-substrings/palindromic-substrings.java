// we can check plaindrome for length 2 to length of string
// but in the process we might end up recomputing some of the other 
// previously done computing therefore lets just just store that info into 
// 2d dp array which tracks if the string between ij is palin or not. 

class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] palin = new boolean[len][len];

        for(int i=0;i<len;i++)palin[i][i] = true;

        for(int i=1;i<len;i++){
            for(int j=0;j<len;j++){
                if(j+i < len){
                    if(!palin[j][i+j] && ifPalin(s, j, j+i, palin)){
                        palin[j][i+j] = true;
                    }
                }
            }
        }

        int count =0;

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(palin[i][j]){
                    count++;
                }
            }
        }

        return count;

    }

    public boolean ifPalin(String s, int i, int j, boolean[][] palin){
        //System.out.println(i+" <> "+j);
        while(i<j){
            if(palin[i][j]){
                //System.out.println("true");
                return true;
            }else if(s.charAt(i) != s.charAt(j)){
                //System.out.println("false");
                return false;
            }
            i++;
            j--;
        }
        //System.out.println("true");
        return true;
    }
}