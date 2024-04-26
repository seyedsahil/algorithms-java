package org.sydlabz.algorithms;

import org.junit.Test;
import org.sydlabz.algorithms.array.ArrayStack;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class ArrayStackTest {
    @Test
    public void stackSizeIsZero() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new ArrayStack<>(0));
        assertEquals("size is invalid", ex.getMessage());
    }

    @Test
    public void stackSizeIsNegative() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new ArrayStack<>(0));
        assertEquals("size is invalid", ex.getMessage());
    }

    @Test
    public void stackFull() {
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            ArrayStack<Integer> stack = new ArrayStack<>(3);
            IntStream.range(0, 3).forEach(stack::push);
            stack.push(3);
        });
        assertEquals("stack is full", ex.getMessage());
    }

    @Test
    public void stackEmpty() {
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            ArrayStack<Integer> stack = new ArrayStack<>(3);
            IntStream.range(0, 3).forEach(stack::push);
            IntStream.range(0, 3).forEach(i -> stack.pop());
            stack.pop();
        });
        assertEquals("stack is empty", ex.getMessage());
    }

    @Test
    public void stackEmptyOnInit() {
        ArrayStack<Integer> stack = new ArrayStack<>(2);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void stackNotEmptyAfterPush() {
        ArrayStack<Integer> stack = new ArrayStack<>(2);
        stack.push(10);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void stackNotEmptyAfterPop() {
        ArrayStack<Integer> stack = new ArrayStack<>(2);
        stack.push(10);
        stack.push(12);
        stack.pop();
        assertFalse(stack.isEmpty());
    }

    @Test
    public void stackSize() {
        ArrayStack<Integer> stack = new ArrayStack<>(4);
        stack.push(10);
        stack.push(12);
        stack.push(13);
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(2, stack.size());
    }

    @Test
    public void stackTopElement() {
        ArrayStack<Integer> stack = new ArrayStack<>(4);
        stack.push(10);
        stack.push(12);
        stack.push(13);
        assertEquals(13, (int) stack.pop());
    }

    @Test
    public void stackEmptyAndPop() {
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            ArrayStack<Integer> stack = new ArrayStack<>(1);
            stack.pop();
        });
        assertEquals("stack is empty", ex.getMessage());
    }

    @Test
    public void stackEmptyAndPeek() {
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            ArrayStack<Integer> stack = new ArrayStack<>(1);
            stack.peek();
        });
        assertEquals("stack is empty", ex.getMessage());
    }

    @Test
    public void stackFullAndPeek() {
        ArrayStack<Integer> stack = new ArrayStack<>(2);
        stack.push(10);
        stack.push(11);
        assertEquals(11, (int) stack.peek());
    }
}
