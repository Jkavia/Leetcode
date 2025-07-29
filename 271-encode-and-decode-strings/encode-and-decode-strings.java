public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();

        for(String s: strs){
            sb.append(s.replace("#","##")).append(" # ");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] strs = s.split(" # ", -1);
        List<String> lst = new ArrayList<>();

        for(int i=0;i<strs.length-1;i++){
            String strr = strs[i].replace("##","#");
            lst.add(strr);
        }
        return lst;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));