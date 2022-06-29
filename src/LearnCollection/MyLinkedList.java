package LearnCollection;

import java.util.*;

public class MyLinkedList implements List {
    static class ListNode{
        ListNode prev;
        ListNode next;
        Object value;
        public ListNode(ListNode prev, ListNode next, Object value){
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    private ListNode start = null;
    private ListNode tail = null;
    private int size = 0;
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        ListNode curr = start;
        while (curr != null){
            if(Objects.equals(curr.value,o)){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        ListNode newNode = new ListNode(tail,null,o);
        if(start == null){
            start = newNode;
        }
        if(tail != null){
            tail.next = newNode;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        start = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if(index>size || index<0){
            throw new IndexOutOfBoundsException("out of bound" + size + "for" + index);
        }
        ListNode curr = start;
        for(int i = 0; i<index;i++){
            curr =curr.next;
        }
        return curr.value;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
