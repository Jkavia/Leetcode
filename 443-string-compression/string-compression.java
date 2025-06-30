class Solution {
    public int compress(char[] chars) {
        // use two ptrs one is moving counting letters and other is moving counting updated representation with numbers
        int idx =0;
        int count =0;

        for(int i=0;i<chars.length;){
            char curr = chars[i];
            count =1;
            i++;

            while(i<chars.length && curr == chars[i]){
                count++;
                i++;
            }

            chars[idx++] = curr;

            if(count > 1){
                char[] arr = String.valueOf(count).toCharArray();
                for(char c: arr){
                    chars[idx++] = c;
                }
            }
        }
        return idx;  
    }
}