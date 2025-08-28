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
   String separator = ",";
   String nullVal = "null";

    // Encodes a tree to a single string. using the left first traversal append all in stringbuffer
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();

        serializeHelper(root, sb);
        return sb.toString();
    }

    public void serializeHelper(TreeNode root, StringBuffer sb){
        if(root == null){
            sb.append(nullVal).append(separator);
            return;
        }

        sb.append(root.val).append(separator);
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(separator);
        Queue<String> que = new LinkedList<>();

        que.addAll(Arrays.asList(vals));

        return deserializeHelper(que);
    }

    public TreeNode deserializeHelper(Queue<String> que){
        if(que.isEmpty())return null;
        String val = que.poll();
        if(val.equals(nullVal)){
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