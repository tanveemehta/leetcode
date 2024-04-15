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
    public int sumNumbers(TreeNode root) {
       return preorder(root,0);
    }
    public int preorder(TreeNode root,int sum){
        if(root == null){
            return 0;
        }
        int newSum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            return newSum;
        }
        return preorder(root.left,newSum)+ preorder(root.right , newSum);
    }
}