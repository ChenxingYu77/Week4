package LearnCollection;

import java.util.*;

public class MyArrayList implements List {
    private Object[] elements;
    private int curr;
    public MyArrayList(){
        elements = new Object[16];
        curr = 0;
    }
    public int size() {return curr;}

    public boolean isEmpty() {return curr == 0;}

    public boolean contains(Object o){
        for(Object ele:elements){
            if(Objects.equals(ele,o)){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        curr = 0;
    }

    public Object get(int index){
        if(index>curr || index<0){
            throw new IndexOutOfBoundsException("out of bound" + curr + "for" + index);
        }
        return elements[index];
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
    public ListIterator listIterator(int index) {throw new UnsupportedOperationException();}

    @Override
    public List subList(int fromIndex, int toIndex) {throw new UnsupportedOperationException();}

    public boolean add(Object o){
        if (curr == elements.length-1){
            elements = new Object[elements.length * 2];
        }
        elements[curr] = o;
        curr++;
        return true;
    }

    public Iterator iterator() { throw new UnsupportedOperationException();}

    public Object[] toArray() { throw new UnsupportedOperationException();}

    @Override
    public Object[] toArray(Object[] a) {throw new UnsupportedOperationException();}

    public boolean remove(Object o){ throw new UnsupportedOperationException();}

    @Override
    public boolean containsAll(Collection c) {throw new UnsupportedOperationException();}

    public boolean addAll(Collection c){ throw new UnsupportedOperationException();}

    @Override
    public boolean addAll(int index, Collection c) {throw new UnsupportedOperationException();}

    @Override
    public boolean retainAll(Collection c) {throw new UnsupportedOperationException();}

    @Override
    public boolean removeAll(Collection c) {throw new UnsupportedOperationException();}

}
