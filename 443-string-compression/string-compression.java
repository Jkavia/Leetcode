class Solution {
    public int compress(char[] chars) {
        // We can run the loop on char array>
        // 1. pick one character and from current i start comparing all the elements from that char 
        // 2. keep incrementing i and count as long as there is match 
        // 3. Once there is a mismatch set this character at jth index(starting 0) in char array and do j++
        // 4. To add count if its 1 skip it, if more than make the int into chararray and add it to the chars.
        // 5. In next iteration it will again repeat the same process. 
        if(chars.length == 1) return 1;
        int count =0;
        int idx =0;
        for(int i=0;i<chars.length;){
            char curr = chars[i];

            while(i<chars.length && curr == chars[i]){
                count++;
                i++;
            }

            chars[idx++] = curr;
            if(count > 1){
                for(char c: String.valueOf(count).toCharArray()){
                    chars[idx++] = c;
                }
            }
            count =0;
        }

        return idx;
    }
}