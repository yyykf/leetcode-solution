package co.code4j.leetcode.cn;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 双栈实现队列
 *
 * @author YuKaiFan
 * @date 2023/3/28
 * @blog <a href="https://code4j.site">https://code4j.site</a>
 */
public class MyQueue<E> {

    /** 输入栈，用于存放新加入的元素 */
    private final Stack<E> inStack;
    /** 输出栈，用于取出最先加入的元素 */
    private final Stack<E> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void offer(E e) {
        // 直接入栈
        this.inStack.push(e);
    }

    public E poll() {
        this.transferInStackToOutStack();

        return this.outStack.pop();
    }

    public E peek(){
        this.transferInStackToOutStack();

        return this.outStack.peek();
    }

    private void transferInStackToOutStack() {
        // 如果输出栈为空，那么将输入栈的元素转移到输出栈
        if (this.outStack.isEmpty()) {
            while (!this.inStack.isEmpty()) {
                this.outStack.push(this.inStack.pop());
            }
        }
    }

    public int size() {
        return this.inStack.size() + this.outStack.size();
    }

    public boolean isEmpty() {
        return this.inStack.isEmpty() && this.outStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        IntStream.rangeClosed(1, 10).boxed().forEach(queue::offer);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        System.out.println("------------------");
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}
