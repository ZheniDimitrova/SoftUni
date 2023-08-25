package implementations;


import interfaces.List;

import java.util.Iterator;

public class ReversedList<E> implements List<E> {
    private final int INITIAL_CAPACITY = 2;

    private Object[] listOfElements;
    private int size;
    private int start;
    private int end;

    public ReversedList() {
        this.listOfElements = new Object[INITIAL_CAPACITY];
        start = 0;
        end = start;

    }

    @Override
    public void add(E element) {
        if (this.size == 0) {
            this.listOfElements[this.end] = element;
        } else {
            if (this.listOfElements.length -1 == this.end) {
                this.listOfElements = grow();
            }
            this.listOfElements[++this.end] = element;
        }

        this.size++;

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.listOfElements.length;
    }

    @Override
    public E get(int index) {
        int reversedIndex = end - index;
        if (!validIndex(reversedIndex)) {
            return null;
        }
        return (E)listOfElements[reversedIndex];

    }


    @Override
    public E removeAt(int index) {

        int reversedIndex = end - index;
        if (!validIndex(reversedIndex)) {
            return null;
        }

        E lastElement = (E)listOfElements[end];
        for (int i = this.end; i > reversedIndex ; i--) {
            E buffer = (E)listOfElements[i-1];
            listOfElements[i-1] = lastElement;
            lastElement = buffer;

        }
        listOfElements[end] = null;

        return (E)listOfElements[reversedIndex];
    }


    private Object[] grow() {
        Object[] newListOfElements = new Object[INITIAL_CAPACITY * 2];

        for (int i = start; i <= end ; i++) {
            newListOfElements[i] = listOfElements[i];
        }

        return newListOfElements;

    }

    private boolean validIndex(int index) {
        return (index >= this.start && index <= this.end);

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = end;

            @Override
            public boolean hasNext() {
                return index >= start;
            }

            @Override
            public E next() {
                return (E)listOfElements[index--];
            }
        };
    }
}
