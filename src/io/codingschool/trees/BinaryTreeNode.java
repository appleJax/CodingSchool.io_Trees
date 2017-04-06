package io.codingschool.trees;

public class BinaryTreeNode<T> {

    public T data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        if (this.left == null && this.right == null)
            return String.valueOf(this.data) + " ";

        String leftString = "";
        String rightString = "";

        if (this.left != null)
            leftString += this.left.toString();

        if (this.right != null)
            rightString = this.right.toString();

        return String.valueOf(this.data) + " " + leftString + rightString;
    }
}
