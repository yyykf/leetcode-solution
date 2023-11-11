package co.code4j.leetcode.cn.common;

import java.lang.reflect.Array;
import java.util.stream.IntStream;

/**
 * @Description
 * @Author yukf02
 * @Date 2023/11/6 16:55
 */
public class StackBasedArray<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int CAPACITY_THRESHOLD = 8;

    private final Class<T> componentType;
    private T[] elements;
    private int pos;
    private int length;

    public boolean push(T e) {
        if (pos == length) {
            // 扩容
            grow();
        }

        elements[pos++] = e;
        return true;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        /*
            小于阈值的数组，长度至少增加1；
            大于等于阈值的数组，1.5倍扩容
         */
        int minCapacity = length < CAPACITY_THRESHOLD ? length + 1 : length + (length >> 1);

        // 创建新数组
        T[] newElements = (T[]) Array.newInstance(componentType, minCapacity);

        // 将旧数组中的元素复制到新数组
        System.arraycopy(elements, 0, newElements, 0, length);

        // 更新数组引用和长度
        elements = newElements;
        length = minCapacity;
    }

    public T pop() {
        if (pos == 0) {
            return null;
        }

        T e = elements[pos--];

        elements[pos] = null;
        return e;
    }

    public T peek() {
        if (pos == 0) {
            return null;
        }

        return elements[pos];
    }

    private StackBasedArray(Class<T> componentType) {
        this(componentType, DEFAULT_CAPACITY);
    }

    private StackBasedArray(Class<T> componentType, int length) {
        this.componentType = componentType;
        this.length = length;
    }

    public static <T> StackBasedArray<T> initStack(Class<T> componentType) {
        return initStack(componentType, DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public static <T> StackBasedArray<T> initStack(Class<T> componentType, int length) {
        StackBasedArray<T> stack = new StackBasedArray<>(componentType, length);
        stack.elements = (T[]) Array.newInstance(componentType, length);
        return stack;
    }

    public static void main(String[] args) {
        StackBasedArray<Integer> stack = initStack(Integer.class, 1);
        IntStream.rangeClosed(1, 10).forEach(stack::push);
        System.out.println(stack);
    }
}
