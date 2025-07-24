class Solution {
    public int reverse(int x) {
        int sign = (x<0)? -1:1;

        if(Math.abs(x) > Integer.MAX_VALUE)return 0;
        try{
        StringBuffer sb = new StringBuffer();
        sb.append(Math.abs(x)).reverse();

        return sign*Integer.parseInt(sb.toString());
        }catch(NumberFormatException e){
            return 0;
        }
    }
}