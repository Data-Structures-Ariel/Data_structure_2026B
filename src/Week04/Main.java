package Week04;

import Week02.BinNode;

import java.util.*;

public class Main {
    static Random rd = new Random();

    static void main() {
//        BinNode<Integer> root = buildTree(new int[]{4, 7, 2, 1, 5, 3, 8, 9, 10, 6}, new int[]{7, 4, 2, 5, 10, 9, 8, 6, 3, 1});

//        inOrder(root);
//        preOrder(root);
        BinNode<Integer> root1 = new BinNode<>(2);
        int x = 5;

        inOrder(root1);
        addToTree(root1, x);
        inOrder(root1);

        BinNode<Integer> root2 = new BinNode<>(21);
        inOrder(root2);
        addToBst(root2, x);
        inOrder(root2);

    }

    public static void addToTree(BinNode<Integer> root, int x) {
        if (root == null)
            return;
        while (root != null) {
            boolean bool = rd.nextBoolean();
            if (bool) {
                if (root.hasLeft())
                    root = root.getLeft();
                else {
                    root.setLeft(new BinNode<>(x));
                    return;
                }
            } else {
                if (root.hasRight())
                    root = root.getRight();
                else {
                    root.setRight(new BinNode<>(x));
                    return;
                }
            }

        }

    }

    public static void addToBst(BinNode<Integer> root, int x) {
        if (root == null)
            return;
        while (root != null) {

            if (x < root.getValue()) {
                if (root.hasLeft())
                    root = root.getLeft();
                else {
                    root.setLeft(new BinNode<>(x));
                    return;
                }
            } else {
                if (root.hasRight())
                    root = root.getRight();
                else {
                    root.setRight(new BinNode<>(x));
                    return;
                }
            }

        }

    }

    public static BinNode<Integer> addToTree(int x, BinNode<Integer> root) {
        if (root == null)
            return new BinNode<>(x);
        return null;
    }

    public static BinNode<Integer> addToBst(int x, BinNode<Integer> root) {
        if (root == null)
            return new BinNode<>(x);
        return null;
    }

    public static BinNode<Integer> buildTree(int[] inOrder, int[] preOrder) {
        if (preOrder == null || inOrder == null || inOrder.length != preOrder.length)
            return null;

        if (preOrder.length == 0 || inOrder.length == 0)
            return null;

        BinNode<Integer> root = new BinNode<>(preOrder[0]);
        int i = 0;
        for (; i < inOrder.length; i++) {
            if (inOrder[i] == preOrder[0])
                break;
        }
        int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
        int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

        int[] preLeft = Arrays.copyOfRange(preOrder, 1, inLeft.length + 1);
        int[] preRight = Arrays.copyOfRange(preOrder, inLeft.length + 2, preOrder.length);

        BinNode<Integer> left = buildTree(inLeft, preLeft);
        BinNode<Integer> right = buildTree(inRight, preRight);
        root.setLeft(left);
        root.setRight(right);
        return root;
    }

    private static void preOrder(BinNode root) {
        if (root == null)
            return;
        System.out.print(root.getValue() + " ");
        inOrder(root.getLeft());
        inOrder(root.getRight());
    }

    private static void inOrder(BinNode root) {
        if (root == null)
            return;
        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }
}
