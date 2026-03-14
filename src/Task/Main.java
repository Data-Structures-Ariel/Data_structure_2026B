package Task;

import Week02.BinNode;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");

        BinNode<Integer> tree = null;
        Queue<Integer> q = allPathSum(tree);
    }

    public static Queue<Integer> allPathSum(BinNode<Integer> tree) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        allPathSum(tree, sum, q);

        return q;

    }
    private static void allPathSum(BinNode<Integer> root, int sum, Queue<Integer> q) {
        if (root == null)
            return;
        sum += root.getValue();
        if(!root.hasLeft() && !root.hasRight())
            q.add(sum);
        if(root.hasLeft())
            allPathSum(root.getLeft(), sum, q);
        if(root.hasRight())
            allPathSum(root.getLeft(), sum, q);
    }
}
