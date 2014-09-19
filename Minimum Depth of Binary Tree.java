/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        int head = 0, tail = 0;
        TreeNode t=null;
        int depth = 1, k;
        while(tail>=head){
            k = tail;
            for (int i = head; i <= k; i++){
                t = list.get(i);
                if (t.left==null && t.right==null){
                    return depth;
                }
                if(t.left!=null){
                    list.add(t.left);
                    tail++;
                }
                if(t.right!=null){
                    list.add(t.right);
                    tail++;
                }
            }
            depth ++;
            head = k+1;
        }
        return depth;
    }
}
