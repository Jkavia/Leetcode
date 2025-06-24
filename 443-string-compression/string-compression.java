class Solution {
    public int compress(char[] chars) {
        int count =1;
        StringBuffer sb = new StringBuffer();

        for(int i=1;i<chars.length;i++){
            if(chars[i] == chars[i-1]){
                count++;
            }else{
                sb.append(chars[i-1]);
                if(count > 1){
                  sb.append(count);
                  count =1;
                }
            }
        }

        sb.append(chars[chars.length-1]);
        if(count > 1){
            sb.append(count);
            }
            int index =0;

        for(char c: sb.toString().toCharArray()){
            chars[index++] = c;
        }
        return sb.length();
    }
}
//["a","a","b","b","c","c","c"]
// a 2 b 2 3