package javasrc;

import java.util.ArrayDeque;

import java.util.Deque;
// need to cast when compare two integers
public class UberMinStack {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    private Deque<Integer> stack3; /// in case a lot of duplicates

    /** initialize your data structure here. */
    public UberMinStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
        stack3 = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack1.isEmpty() || x < stack2.peek()) {
            stack1.push(x);
            stack2.push(x);
            stack3.push(stack1.size());

        } else {
            stack1.push(x);
        }
        System.out.println("stack1" + stack1.peek());


    }

    public void pop() {
        if ((int)stack2.peek() == (int)(stack1.peek()) && (int)stack1.size() == (int)(stack3.peek())) {
            stack2.pop();
            stack3.pop();
            System.out.println("stack2" + stack2.peek());
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();

    }

    public int getMin() {
        return stack2.peek();

    }
}
