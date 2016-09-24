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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        Queue<TreeNode> q = new LinkedList();
        StringBuilder res = new StringBuilder();
        
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            
            if(node == null) {
                res.append("n ");
                continue;
            }
            
            res.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }
        
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null; 
        Queue<TreeNode> q = new LinkedList();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        
        q.offer(root);
        
        for(int i = 1; i < values.length; i++) {
            TreeNode node = q.poll();
            
            if(!values[i].equals("n")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(node.left);
            }
            
            if(!values[++i].equals("n")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(node.right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));