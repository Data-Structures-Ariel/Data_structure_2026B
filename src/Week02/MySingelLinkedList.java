package Week02;

import Week01.Node;

import java.util.*;

public class MySingelLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MySingelLinkedList() {
        this.head = null;
        this.size = 0;
    }

    //O(1)
    @Override
    public int size() {
        return size;
    }

    //O(1)
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    //O(n)
    @Override
    public boolean contains(Object o) {
        //implements
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    //O(1)
    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
        return true;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = tail = newNode;
        } else {
//            newNode.setNext(head);
//            head = newNode;
            head = new Node<>(e,head,null);
        }
        size++;
    }

    //O(n)
    @Override
    public boolean remove(Object o) {
        //implements
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    //O(1)
    @Override
    public void clear() {
        //implements
    }

    //O(n)
    @Override
    public E get(int index) {
        //implements
        return null;
    }

    //O(n)
    @Override
    public E set(int index, E element) {
        //implements
        return null;
    }

    //O(n)
    @Override
    public void add(int index, E element) {
        //implements
    }

    //O(n)
    @Override
    public E remove(int index) {
        //implements
        if (isEmpty() || index < 0 || index >= size) {
            throw new NoSuchElementException();
        }

        Node<E> curr = head;
        Node<E> prev = null;

        while (curr != null) {
            prev = curr;
            curr = curr.getNext();
        }

        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;   //implements
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;   //implements
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
