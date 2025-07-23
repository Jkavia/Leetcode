class Solution {
    public int reverse(int x) {
        int sign = (x<0)? -1:1;
        String s = String.valueOf(Math.abs(x));
        StringBuffer sb = new StringBuffer();

        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        int res = 0;

        try{
            res = Integer.parseInt(sb.toString());
        }catch(NumberFormatException e){
            return 0;
        }

        return sign*res;
    }
}