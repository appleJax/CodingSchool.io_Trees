package io.codingschool.trees;

public class Main {

    private static int[] treeNums = new int[] {
            30, 10, 8, 6, 3, 5, 2, 20, 98, 35, 24, 60, 72, 1, 35, 80
    };

    // private static int[] treeNums = new int[] { 10, 8, 5, 9, 11, 18, 30 };

    private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
        if (root == null)
            return new BinaryTreeNode<Integer>(data);

        BinaryTreeNode<Integer> subTree;

        if (data <= root.data) {
            subTree = insert(root.left, data);
            root.left = subTree;
        } else {
            subTree = insert(root.right, data);
            root.right = subTree;
        }

        return root;
    }

    private static int sumTree(BinaryTreeNode<Integer> node) {
        if (node == null)
            return 0;

        return node.data + sumTree(node.left) + sumTree(node.right);
    }

    private static void preOrderPrint(BinaryTreeNode root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    private static void postOrderPrint(BinaryTreeNode root) {
        if (root == null)
            return;

        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.print(root.data + " ");
    }

    private static void inOrderPrint(BinaryTreeNode root) {
        if (root == null)
            return;

        inOrderPrint(root.left);
        System.out.print(root.data + " ");
        inOrderPrint(root.right);
    }

    private static void printLeaves(BinaryTreeNode root) {
        if (root == null) {
            return;

        } else if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
            return;
        }

        printLeaves(root.left);
        printLeaves(root.right);
    }

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = null;

        for (int node : treeNums)
            root = insert(root, node);

        System.out.print("toString Tree values: " + root);
        System.out.println();

        System.out.print("Preorder Tree values: ");
        preOrderPrint(root);
        System.out.println();

        System.out.print("PostOrder Tree value: ");
        postOrderPrint(root);
        System.out.println();

        System.out.print("In Order Tree values: ");
        inOrderPrint(root);
        System.out.println();

        System.out.print("Tree Leaves: ");
        printLeaves(root);
        System.out.println();

        System.out.println("Sum of tree values: " + sumTree(root));
    }
}
