package Week08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static Week08.Task.*;

public class Main {
    public static void main(String[] args) {


        Stack<Integer> s1 = new Stack<>();
        s1.push(5);
        s1.push(3);
        s1.push(5);

        Stack<Integer> s2 = new Stack<>();
        s2.push(2);
        s2.push(5);

        Stack<Integer> s3 = new Stack<>();
        s3.push(3);
        s3.push(5);
        s3.push(7);

        Stack<Integer> s4 = new Stack<>();
        s4.push(1);
        s4.push(3);


        BinNode<Stack<Integer>> t1_left = new BinNode<>(s1);
        BinNode<Stack<Integer>> t1_right = new BinNode<>(s2);
        BinNode<Stack<Integer>> t1_root =
                new BinNode<>(new Stack<>(), t1_left, t1_right);


        BinNode<Stack<Integer>> t2_left = new BinNode<>(s3);
        BinNode<Stack<Integer>> t2_right = new BinNode<>(s4);
        BinNode<Stack<Integer>> t2_root =
                new BinNode<>(new Stack<>(), t2_left, t2_right);

        Queue<BinNode<Stack<Integer>>> treesQueue = new LinkedList<>();
        treesQueue.add(t1_root);
        treesQueue.add(t2_root);

        int result = mostFrequentNumber(treesQueue);

        System.out.println("Most frequent number: " + result);


        Stack<Character> stackA = new Stack<>();
        stackA.push('a');
        stackA.push('a');
        stackA.push('b');
        stackA.push('b');

        boolean isValid = isAnBn(stackA);
        System.out.println("Section A - isAnBn result: " + isValid);


        Stack<Character> stackB = new Stack<>();


        stackB.push('e');
        stackB.push('e');
        stackB.push('e');
        stackB.push('a');
        stackB.push('b');
        stackB.push('a');
        stackB.push('b');
        stackB.push('c');
        stackB.push('d');
        stackB.push('d');
        stackB.push('c');
        stackB.push('d');

        int count = countStrictAnBn(stackB);
        System.out.println("Section B - countStrictAnBn result: " + count);
    }
}
