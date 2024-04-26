package org.sydlabz.algorithms.array;

import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T> {
    private final Object[] elements;
    private int top;

    public ArrayStack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size is invalid");
        }

        elements = new Object[size];
        top = -1;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }

        return (T) elements[top--];
    }

    public void push(T element) {
        if (top == elements.length - 1) {
            throw new IllegalStateException("stack is full");
        }

        elements[++top] = element;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }

        return (T) elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator<>();
    }

    private class ArrayStackIterator<T> implements Iterator<T> {
        private int next;

        private ArrayStackIterator() {
            next = top;
        }

        @Override
        public boolean hasNext() {
            return next > -1;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("iterator closed");
            }

            return (T) elements[next--];
        }
    }
}
