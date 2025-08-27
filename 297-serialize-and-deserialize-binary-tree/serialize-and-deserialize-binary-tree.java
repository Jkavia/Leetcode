/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string. Use stringbuffer and recursion 
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        String nullVal = "null";
        String separator = ",";
        serializeHelper(root, sb, nullVal, separator);
        return sb.toString();
    }

    public void serializeHelper(TreeNode root, StringBuffer sb, String nullVal, String separator){
        if(root == null){
            sb.append(nullVal).append(separator);
            return;
        }

        sb.append(root.val).append(separator);
        serializeHelper(root.left, sb, nullVal, separator);
        serializeHelper(root.right, sb, nullVal, separator);
    }

    // Decodes your encoded data to tree. Use que and recursion 
    public TreeNode deserialize(String data) {
        Queue<String> que = new LinkedList<>();
        que.addAll(Arrays.asList(data.split(",")));
        
        return deserializeHelper(que);
    }

    public TreeNode deserializeHelper(Queue<String> que){
        if(que.isEmpty())return null;
        String val = que.poll();

        if(val.equals("null")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(que);
        root.right = deserializeHelper(que);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));