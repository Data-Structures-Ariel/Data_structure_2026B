package Week02;

import Week01.Node;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Queue;

public class QueueWithNode<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public QueueWithNode() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
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
        if (head == null) {
            head = tail = new Node(e);
        } else {
            tail.setNext(new Node(e));
            tail = tail.getNext();
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {

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
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    //O(1)
    @Override
    public E poll() {
        if (head == null)
            throw new EmptyStackException();
        E item = head.getValue();
        head = head.getNext();
        return item;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
