package com.husky.tree;

public class BinaryTree<T> {
    private Node<T> root;



    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空无法遍历");
        }
    }
    public void midOrder(){
        if (this.root != null){
            this.root.midOrder();
        }else {
            System.out.println("二叉树为空无法遍历");
        }
    }
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空无法遍历");
        }
    }

    class Node<T>{
       private Node<T> left;
       private Node<T> right;
       private int num;
       private T data;

        public Node(int num, T data) {
            this.num = num;
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", data=" + data +
                    '}';
        }

        public void preOrder(){
            System.out.println(this);
            if (this.left != null){
                this.left.preOrder();
            }
            if (this.right != null){
                this.right.preOrder();
            }
        }
        public void midOrder(){
            if (this.left != null){
                this.left.midOrder();
            }
            System.out.println(this);
            if (this.right != null){
                this.right.midOrder();
            }
        }
        public void postOrder(){
            if (this.left != null){
                this.left.postOrder();
            }
            if (this.right != null){
                this.right.postOrder();
            }
            System.out.println(this);
        }
    }

    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree<String>().new Node<String>(1,"张三");
        BinaryTree.Node node1 = new BinaryTree<String>().new Node<String>(2,"李四");
        BinaryTree.Node node2 = new BinaryTree<String>().new Node<String>(3,"王五");
        BinaryTree.Node node3 = new BinaryTree<String>().new Node<String>(4,"赵六");
        BinaryTree.Node node4 = new BinaryTree<String>().new Node<String>(5,"田七");
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node2.setRight(node4);
        BinaryTree<String> stringBinaryTree = new BinaryTree<String>();
        stringBinaryTree.setRoot(root);
        stringBinaryTree.preOrder();
    }
}
