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
        TreeNode level1R = new TreeNode(6, level1Rl, level1Rr);
        /**
         *     4
         *  2   6
         * 1 3 5 7
         */
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = new TreeNode(4, level1L, level1R);
        tree.preOrder(root); // 4->2->1->3->6->5->7
        tree.inOrder(root); // 1->2->3->4->5->6->7
        tree.postOrder(root); // 1->3->2->5->7->6->4
        System.out.println(tree.find(6,  root) == level1R);
        tree.insert(8, root);
        tree.preOrder(root);
        System.out.println("==============delete====");
        tree.delete(4, root);
        tree.preOrder(root);
    }

    public static class TreeNode {

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

    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("pre ==>" + root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println("in ==>" + root.data);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println("post ==>" + root.data);
    }

    public TreeNode find(int data, TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode n;
        if (root.data < data) {
            n = root.right;
        } else if(root.data > data){
            n = root.left;
        }else{
            return root;
        }
        return find(data, n);
    }

    public void insert(int data, TreeNode root) {
        if(root == null){
            root = new TreeNode(data, null, null);
            return;
        }
        if(root.data < data){
            if (root.right == null) {
                root.right = new TreeNode(data, null, null);
                return;
            }else{
                root = root.right;
            }
        }else{
            if(root.left == null){
                root.left = new TreeNode(data, null, null);
                return;
            }else{
                root = root.left;
            }
        }
        insert(data, root);
    }

    public void delete(int data, TreeNode root) {
        TreeNode p = root;
        TreeNode parent = null;
        while (p != null && p.data != data){
            parent = p;
            if(p.data > data){
                p = p.left;
            }else{
                p = p.right;
            }
        }
        // 没有找到
        if(p == null){
            return;
        }
        if(p.left != null && p.right != null){
            // 要删除的节点的左右子节点都不为空，找到右子树中最小的叶子节点，放到要删除的位置
            TreeNode min = p.right;
            TreeNode minParent = p;
            while (min.left != null){
                minParent = min;
                min = min.left;
            }
            // 此时的p是待删除节点的引用对象，将待删除节点对象里的data的值改动为找到的节点的值
            p.data = min.data;
            // 此时p就从之前的待删除节点变成了右子树中最小节点，相当于将两个子节点问题变成了0或1个子节点问题 这样就保证了后面的处理代码一致
            p = min;
            parent = minParent;
        }
        TreeNode child;
        if(p.left != null){
            child = p.left;
        }else if(p.right != null){
            child = p.right;
        }else{
            child = null;
        }

        // 要删除的是根节点的情况
        if(parent == null){
            if (child != null) {
                root.data = child.data;
                root.left = child.left;
                root.right = child.right;
            }
        }else if(parent.left == p){
            parent.left = child;
        }else{
            parent.right = child;
        }
    }

}
