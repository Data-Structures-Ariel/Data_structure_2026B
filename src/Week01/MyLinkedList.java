package Week01;

import java.util.*;

public class MyLinkedList<E> implements List<E> {

    private Node<E> head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
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

    //O(n)
    @Override
    public boolean add(E e) {
        Node newNode = new Node(e);
        if (isEmpty()) {
            head = newNode;
            return true;
        }
        Node temp = head;
        while (temp.hasNext())
            temp = temp.getNext();

        temp.setNext(newNode);

        return true;
    }

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

    @Override
    public void clear() {
        //implements
    }

    @Override
    public E get(int index) {
        //implements
        return null;
    }

    @Override
    public E set(int index, E element) {
        //implements
        return null;
    }

    @Override
    public void add(int index, E element) {
        //implements
    }


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
