package week01;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Node<Integer> chain = new Node(1, null, null);
        chain.setNext(new Node<>(2, null, chain));
        Node<Integer> next = chain.getNext();
        next.setNext(new Node<>(3, null, next));

        add(chain, 4);
        chain = addFirst(chain, 4);


    }

    private static void add(Node<Integer> root, int value) {
        if (root == null)
            return;
        Node<Integer> newNode = new Node<>(value);
        while (root.hasNext())
            root = root.getNext();

        root.setNext(newNode);
        newNode.setPrev(root);
    }

    private static Node<Integer> addFirst(Node<Integer> root, int value) {

        Node<Integer> newNode = new Node<>(value);
        if (root == null)
            return newNode;

        newNode.setNext(root);
        root.setPrev(newNode);

        return newNode;
    }

    private static boolean addByIndex(Node<Integer> root, int value, int index) {
        if (root == null || index <= 0)
            return false;

        int size = 0;
        Node<Integer> temp = root;
        while (temp != null) {
            size++;
            temp = temp.getNext();
        }
        if (index > size)
            return false;

        if (index == size) {
            add(root, value);
            return true;
        }

        for (int i = 0; i < index - 1; i++) {
            root = root.getNext();
        }
        Node<Integer> newNode = new Node<>(value);
        newNode.setNext(root.getNext());
        root.setNext(newNode);
        newNode.setPrev(root);
        newNode.getNext().setPrev(newNode);

        return true;
    }

    public static boolean isMDiv(Node<Integer> chain, int m) {

        if (chain == null)
            return true;
        int cnt = 0;
        while (chain != null) {
            cnt++;
            if (chain.getValue() % m != 0)
                return false;
        }
        return cnt % m == 0;
    }
}
