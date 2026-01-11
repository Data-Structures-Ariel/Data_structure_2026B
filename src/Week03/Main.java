package Week03;

import Week02.BinNode;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static void main() {

        BinNode<Character> root = new BinNode<>('+',
                new BinNode<>('*', new BinNode<>('7'), new BinNode<>('3')),
                new BinNode<>('-', new BinNode<>('9'), new BinNode<>('+',
                        new BinNode<Character>('*', new BinNode<>('4'),
                                new BinNode<>('6')), new BinNode<>('8'))));
        System.out.println(" ---------------------- InOrder --------------------------");
        inOrder(root);
        System.out.println("\n---------------------- PreOrder --------------------------");
        preOrder(root);
        System.out.println("\n---------------------- PostOrder --------------------------");
        postOrder(root);
        System.out.println("\n------------------------------------------------------------");


        int count = countLeaves(root);
        count = countNodes(root);
        char x = '5';
        boolean bool = exist(root, x);
        char y = '6';
        bool = descendent(root, x, y);

        levelOrder(root);
        int[] inOrder = {};
        int[] preOrder = {};
        BinNode<Integer> t = buildTree(inOrder, preOrder);


    }

    public static BinNode<Integer> buildTree(int[] inOrder, int[] preOrder) {
        buildTree(null, new int[]{}, new int[]{});
        return null;
    }

    private static BinNode<Integer> buildTree(BinNode<Integer> root, int[] inOrder, int[] preOrder) {
        return null;

    }

    private static void levelOrder(BinNode<Character> root) {
        if (root == null)
            return;
        Queue<BinNode<Character>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinNode<Character> item = q.poll();
            if (root.hasLeft())
                q.add(root.getLeft());
            if (root.hasRight())
                q.add(root.getRight());
            System.out.print(item.getValue() + " ");
        }

    }

    //O(n)
    private static boolean descendent(BinNode<Character> root, char x, char y) {
        if (root == null)
            return false;
        if (root.getValue() == x)
            return exist(root.getLeft(), y) || exist(root.getRight(), y);
        return descendent(root.getLeft(), x, y) || descendent(root.getRight(), x, y);

    }

    //O(n)
    private static boolean exist(BinNode<Character> root, char x) {
        if (root == null)
            return false;
        if (root.getValue() == x)
            return true;
        return exist(root.getLeft(), x) || exist(root.getRight(), x);
    }

    private static int countNodes(BinNode<Character> root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());

    }

    private static int countLeaves(BinNode<Character> root) {
        if (root == null)
            return 0;
        if (root.getLeft() == null && root.getRight() == null)
            return 1;
        return countLeaves(root.getLeft()) + countLeaves(root.getRight());
    }

    private static void postOrder(BinNode<Character> root) {
        if (root == null)
            return;
        inOrder(root.getLeft());
        inOrder(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    private static void preOrder(BinNode<Character> root) {
        if (root == null)
            return;
        System.out.print(root.getValue() + " ");
        inOrder(root.getLeft());
        inOrder(root.getRight());
    }

    private static void inOrder(BinNode<Character> root) {
        if (root == null)
            return;
        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }
}
