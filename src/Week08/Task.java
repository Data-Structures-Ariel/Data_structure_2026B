package Week08;

import java.util.*;



public class Task {


    public static int mostFrequentNumber(Queue<BinNode<Stack<Integer>>> treesQueue) {

        List<Pair> freqList = new ArrayList<>();
        int bestValue = 0;
        int bestCount = 0;

        while (!treesQueue.isEmpty()) {
            BinNode<Stack<Integer>> root = treesQueue.poll();
            if (root == null) continue;

            Queue<BinNode<Stack<Integer>>> nodes = new LinkedList<>();
            nodes.add(root);

            while (!nodes.isEmpty()) {
                BinNode<Stack<Integer>> node = nodes.poll();

                Stack<Integer> stack = node.getValue();
                while (!stack.isEmpty()) {
                    int x = stack.pop();

                    boolean found = false;
                    for (Pair p : freqList) {
                        if (p.value == x) {
                            p.count++;

                            if (p.count > bestCount) {
                                bestCount = p.count;
                                bestValue = x;
                            }
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        freqList.add(new Pair(x, 1));
                        if (bestCount == 0) {
                            bestCount = 1;
                            bestValue = x;
                        }
                    }
                }

                if (node.hasLeft()) nodes.add(node.getLeft());
                if (node.hasRight()) nodes.add(node.getRight());
            }
        }

        return bestValue;
    }
    public static boolean isAnBn(Stack<Character> stack) {
        int countB = 0;
        int countA = 0;


        while (!stack.isEmpty() && stack.peek() == 'b') {
            stack.pop();
            countB++;
        }


        while (!stack.isEmpty() && stack.peek() == 'a') {
            stack.pop();
            countA++;
        }


        return stack.isEmpty() && countA == countB;
    }
    public static int countStrictAnBn(Stack<Character> stack) {

        Stack<Character> temp = new Stack<>();


        char[] chars = new char[stack.size()];
        int[] counts = new int[stack.size()];
        int size = 0;

        while (!stack.isEmpty()) {
            char c = stack.pop();
            temp.push(c);

            int index = indexOf(chars, size, c);
            if (index == -1) {
                chars[size] = c;
                counts[size] = 1;
                size++;
            } else {
                counts[index]++;
            }
        }


        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }


        int result = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (counts[i] == counts[j]) {
                    result += 2; // x^n y^n and y^n x^n
                }
            }
        }

        return result;
    }


    private static int indexOf(char[] chars, int size, char c) {
        for (int i = 0; i < size; i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }

}



