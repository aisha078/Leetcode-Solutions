/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Swap the values of the two incorrect nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {

        // Base case
        if (node == null)
            return;

        // Traverse left subtree
        inorder(node.left);

        // Check for BST property violation
        if (prev != null && prev.val > node.val) {

            // First violation
            if (first == null) {
                first = prev;
            }

            // Update second node
            second = node;
        }

        // Update previous node
        prev = node;

        // Traverse right subtree
        inorder(node.right);
    }
}