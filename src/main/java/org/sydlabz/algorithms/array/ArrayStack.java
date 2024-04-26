package org.sydlabz.algorithms.array;

public class ArrayStack<T> {
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
        if (top == -1) {
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
        if (top == -1) {
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
}
