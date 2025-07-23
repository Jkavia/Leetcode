class Solution {
    public int reverse(int x) {
        int sign = (x<0)? -1:1;
        String s = String.valueOf(x);
        String updated = (x<0)? s.substring(1, s.length()):s;
        //System.out.println(updated);
        StringBuffer sb = new StringBuffer();

        for(int i=updated.length()-1;i>=0;i--){
            sb.append(updated.charAt(i));
        }

        if(Long.parseLong(sb.toString()) > Integer.MAX_VALUE){
            return 0;
        }

        return sign*Integer.parseInt(sb.toString());
    }
}