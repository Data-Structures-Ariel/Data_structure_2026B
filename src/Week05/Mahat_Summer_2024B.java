package Week05;

import Week01.Node;
import Week02.BinNode;

import java.util.Scanner;
import java.util.Stack;

public class Mahat_Summer_2024B {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Scanner in = new Scanner(System.in);


    static void main() {
        boolean bool;
        while (true) {
            System.out.println("Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:


                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    BinNode<Integer> root = null;
                    bool = isOrderedTree(root);
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case -1:
                    return;
            }
        }
    }


    private static boolean isOrderedTree(BinNode<Integer> root) {
        if (root == null)
            return true;

        if (root.hasLeft() || root.hasRight()) {

            if (root.hasLeft()) if (root.getLeft().getValue() <= root.getValue()) return false;
            if (root.hasRight()) if (root.getRight().getValue() <= root.getValue()) return false;

            if (root.getValue() % 2 == 0)
                return isOrderedTree(root.getLeft()) && isOrderedTree(root.getRight());
            return false;
        }

        return root.getValue() % 2 != 0;

    }

    private static boolean isOrderedTreeV2(BinNode<Integer> root) {
        if (root == null)
            return true;

        boolean hasLeft = root.hasLeft();
        boolean hasRight = root.hasRight();

        if (hasLeft || hasRight)
            if (root.getValue() % 2 != 0) return false;

        if (!hasLeft && !hasRight)
            if (root.getValue() % 2 == 0) return false;

        if (hasLeft) if (root.getLeft().getValue() <= root.getValue()) return false;
        if (hasRight) if (root.getRight().getValue() <= root.getValue()) return false;

        return isOrderedTreeV2(root.getLeft()) && isOrderedTreeV2(root.getRight());


    }

    //O(n) עוברים על המחסנית לכל היותר פעמיים
    public static boolean isParityStack(Stack<Integer> st) {

        if (st == null)
            return false;

        Stack<Integer> stTemp = new Stack<>();
        int sumOdd = 0, sumEven = 0, cntOdd = 0, cntEven = 0;
        boolean bool = true;
        while (!st.isEmpty()) {

            stTemp.push(st.pop());
            if (stTemp.peek() <= 0) {
                bool = false;
                break;
            }
            if (stTemp.peek() % 2 == 0) {
                sumEven += stTemp.peek();
                cntEven++;
            } else {
                sumOdd += stTemp.peek();
                cntOdd++;
            }

        }
        while (!stTemp.isEmpty())
            st.push(stTemp.pop());

        if (sumEven == sumOdd && cntEven == cntOdd)
            return bool;

        return false;
    }

    public static boolean isParityStackV2(Stack<Integer> st) {

        if (st == null)
            return false;

        Stack<Integer> stTemp = new Stack<>();
        int sum = 0, cnt = 0;

        while (!st.isEmpty()) {

            stTemp.push(st.pop());
            if (stTemp.peek() <= 0)
                break;

//            sum += (stTemp.peek() % 2 == 0) ? stTemp.peek() : -stTemp.peek();
//            cnt += (stTemp.peek() % 2 == 0) ? 1 : -1;

            if (stTemp.peek() % 2 == 0) {
                sum += stTemp.peek();
                cnt++;
            } else {
                sum -= stTemp.peek();
                cnt--;
            }

        }
        while (!stTemp.isEmpty())
            st.push(stTemp.pop());

        if (sum == 0 && cnt == 0)
            return true;

        return false;
    }


    //O(n) - עוברים על השרשרת פעם אחת בלבד
    public static boolean repeatList(Node<Character> chain) {

        if (chain == null || !chain.hasNext())
            return false;

        int[] ascii = new int[256];
        Node<Character> pointer = chain;

        while (pointer != null) {
            ascii[pointer.getValue()]++;
            pointer = pointer.getNext();
        }

        for (int i = 0; i < ascii.length; i++) {
            if (ascii[i] > 0 && ascii[i] != 2)
                return false;
        }

        return true;

    }


}

