package ss10_dsa_list_set.exercise.my_array_list;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    public static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IndexOutOfBoundsException( "capacity : " + capacity );
        }
    }

    private void ensureCapacity(int minCapacity) {
        elements = Arrays.copyOf( elements, elements.length + minCapacity );
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            ensureCapacity( 1 );
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public boolean add(E element) {
        add( size, element );
        return true;
    }

    public int size() {
        return size;
    }

    public E remove(int index) {
        E element = ((E) elements[index]);
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return element;
    }

    public MyArrayList<E> clone() {
        return this;
    }

    public boolean constant(E object) {
        for (Object element : elements) {
            if (((E) element).equals( object )) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E object) {
        for (int i = 0; i < size; i++) {
            if (((E) elements[i]).equals( object )) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        size = 0;
        elements = null;
    }

    public E get(int index) {
        return ((E) elements[index]);
    }

}
