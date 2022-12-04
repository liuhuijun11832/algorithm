package com.joy.tree;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        TreeNode level1Ll = new TreeNode(1, null, null);
        TreeNode level1Lr = new TreeNode(3, null, null);
        TreeNode level1Rl = new TreeNode(5, null, null);
        TreeNode level1Rr = new TreeNode(7, null, null);
        TreeNode level1L = new TreeNode(2, level1Ll, level1Lr);
        TreeNode level1R = new TreeNode(6, level1Rl ,level1Rr);
        /**
         *     4
         *  2   6
         * 1 3 5 7
         */
        TreeNode root = new TreeNode(4,level1L, level1R);
        root.preOrder(root); // 4->2->1->3->6->5->7
        root.inOrder(root); // 1->2->3->4->5->6->7
        root.postOrder(root); // 1->3->2->5->7->6->4
    }

    public static class TreeNode{

        private int data;

        private TreeNode left;

        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public void preOrder(TreeNode root){
            if (root == null) {
                return;
            }
            System.out.println("pre ==>" + root.data);
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder(TreeNode root){
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.println("in ==>" + root.data);
            inOrder(root.right);
        }

        public void postOrder(TreeNode root){
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.println("post ==>" + root.data);
        }

    }


}
