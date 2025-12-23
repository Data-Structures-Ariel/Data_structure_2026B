package Week07;

import java.util.Scanner;
import java.util.Stack;

import Week01.*;

public class Mahat_Summer_2025B {

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

    public static void main(String[] args) {

        while (true) {
            System.out.println("Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    Stack<Integer> st = new Stack<>() {{
                        push(41);
                        push(555);
                        push(4);
                        push(37);
                        push(40);
                        push(91);
                        push(987);
                        push(900);
                        push(3);
                        push(2215);
                        push(2);
                        push(307);
                        push(31);
                    }};
                    int k = 2;
                    boolean bool = isProperK(st, k);
                    System.out.println(k + " " + bool);

                    k = 9;
                    bool = isProperK(st, k);
                    System.out.println(k + " " + bool);

                    k = 5;
                    bool = isProperK(st, k);
                    System.out.println(k + " " + bool);

                    k = 3;
                    bool = isProperK(st, k);
                    System.out.println(k + " " + bool);
                    System.out.println(st);
                    fixIt(st, k);
                    bool = isProperK(st, k);
                    System.out.println(k + " " + bool);
                    System.out.println(st);
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


    public static boolean goodNum(int num, int k) {
        while (num >= 10) {
            num /= 10;
        }
        return num == k;
    }

    public static boolean isProperK_Hila(Stack<Integer> st, int k) {
        if (st == null || st.isEmpty())
            return false;

        Stack<Integer> temp = new Stack<>();

        boolean findDif = false;
        boolean findOne = false;
        boolean findOther = false;

        while (!st.isEmpty()) {
            int num = st.pop();
            temp.push(num);
            if (goodNum(num, k)) {
                if (findDif) {
                    findOther = true;
                    break;
                } else
                    findOne = true;
            } else if (findOne) {
                findDif = true;
            }
        }
        while (!temp.isEmpty()) {
            int num = temp.pop();
            st.push(num);
        }
        return !findOther && findOne;
    }

    public static boolean isProperK(Stack<Integer> st, int k) {
        Stack<Integer> temp = new Stack<>();

        boolean foundK = false;
        boolean endedKBlock = false;

        while (!st.isEmpty()) {
            int num = st.pop();
            temp.push(num);

            int firstDigit = getFirstDigit(num);

            if (firstDigit == k)
                if (endedKBlock) {
                    restore(st, temp);
                    return false;
                } else
                    foundK = true;
            else if (foundK)
                endedKBlock = true;
        }

        restore(st, temp);
        return foundK;
    }


    private static void restore(Stack<Integer> st, Stack<Integer> temp) {
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    private static int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    public static void fixIt(Stack<Integer> st, int k) {

        if (isProperK(st, k))
            return;

        Stack<Integer> kStack = new Stack<>();
        Stack<Integer> otherStack = new Stack<>();

        while (!st.isEmpty()) {
            int num = st.pop();
            if (getFirstDigit(num) == k)
                kStack.push(num);
            else
                otherStack.push(num);
        }
        while (!kStack.isEmpty())
            st.push(kStack.pop());

        while (!otherStack.isEmpty())
            st.push(otherStack.pop());

    }


}

class StarCount {
    Node<Integer> number;


    public void fixNumberY() {
        if (number == null)
            return;
        // 6➔471➔5➔23
        // 1➔5➔23
        // 6➔471➔1➔5➔23
        // 6➔47➔1➔5➔23

        // 7➔1➔5➔23
        // 6➔4➔7➔1➔5➔23
        Node<Integer> current = number;
        while (current != null) {
            int curVal = current.getValue();
            while (curVal / 10 > 0) {
                Node<Integer> temp = new Node<>(curVal % 10);
                temp.setNext(current.getNext());
                current.setNext(temp);
                current.setValue(curVal / 10);
                curVal /= 10;
            }
            current = current.getNext();
        }

    }

    // 6➔471➔5➔23
    // 6➔4->7->1➔null
    // 6➔4➔7➔1➔5➔23null
    // prev =
    public void fixNumber() {
        if (number == null)
            return;
        Node<Integer> current = number;
        Node<Integer> prev = null;
        while (current != null) {
            int item = current.getValue();
            if (item > 9) {
                Node[] newArr = buildNumber(item);
                if (prev != null)
                    prev.setNext(newArr[0]);

                newArr[1].setNext(current.getNext());
                current = newArr[1];
            }
            prev = current;
            current = current.getNext();
        }

    }

    //12345
    private Node[] buildNumber(int n) {
        Node<Integer> newNode = new Node<>(n % 10);
        Node<Integer> tail = newNode;

        // newNode - > 5

        // node -> 5
        // newNode -> 4 -> 5

        // node -> 4 -> 5
        // newNode -> 3 -> 4 -> 5

        // node -> 3 -> 4 -> 5
        // newNode 2 -> 3 -> 4 -> 5

        // node - > 2 -> 3 -> 4 -> 5
        // newNode - > 1 -> 2 -> 3 -> 4 -> 5
        while ((n /= 10) != 0) {
            Node<Integer> node = newNode;
            newNode = new Node<>(n % 10);
            newNode.setNext(node);
        }

        return new Node[]{newNode, tail};

    }

    //O(n)
    public void addOne() {
        if (number == null)
            number = new Node<>(1);
        else {
            int c = addOneRec(number);
            if (c == 1) ;
            number = new Node<>(1, number,null);
        }


    }
    private int updateChain(Node<Integer> chain, int item, int c) {
        item += c;
        if (item > 9) {
            chain.setValue(0);
            return 1;
        } else {
            chain.setValue(item);
            return 0;
        }

    }

    private int addOneRec(Node<Integer> chain) {
        if (chain.getNext() == null) {
            int item = chain.getValue();
            return updateChain(chain, item, 1);
        } else {
            int c = addOneRec(chain.getNext());
            int item = chain.getValue();
            return updateChain(chain, item, c);
        }
    }
}
