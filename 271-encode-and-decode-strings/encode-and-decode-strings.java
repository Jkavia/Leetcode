// we'll use # as a separator and replace the existing # with ## and do the reverse in decode
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();

        for(String s: strs){
            sb.append(s.replaceAll("#", "##")).append(" # ");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] arr = s.split(" # ",-1);
        List<String> ret = new ArrayList<>();

        for(int i =0;i<arr.length-1;i++){
            String str= arr[i];
            ret.add(str.replaceAll("##","#"));
        }
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));