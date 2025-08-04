/**
we'll first replace all # in the string with ## and then add separator as ' # '
then append the string.
**/


public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();

        for(String s: strs){
            sb.append(s.replace("#", "##")).append(" # ");
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<>();
        String[] str= s.split(" # ",-1);
        for(int i=0;i<str.length-1;i++){

            String updated = str[i].replace("##","#");
            ret.add(updated);
        }
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));