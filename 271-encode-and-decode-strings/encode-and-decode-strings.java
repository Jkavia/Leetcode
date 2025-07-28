public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            if(s.isEmpty()){sb.append("empty");}else{sb.append(s);}
            sb.append("₹");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String st) { 
        //System.out.println(st);
        String[] strs = st.split("₹");
        List<String> ret = new ArrayList<>();
        
        for(String s:strs){
            if(s.equals("empty")){ret.add("");}else{ret.add(s);}
        }
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));