package junior.dailyPractice._20221220;

/**
 * 使用单链表实现栈
 */
public class PracticeStackBySingleList {
    public static void main(String[] args) {
        StackNodeBySingleList<Integer> stack = new StackNodeBySingleList<>();
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.isEmpty());
        System.out.println("-------------");

        stack.push(10);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.size());
        System.out.println("=============");

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.poll());
        System.out.println(stack.size());
        System.out.println("-------------");
        System.out.println(stack.poll());
        System.out.println(stack.size());
        System.out.println("-------------");
        System.out.println(stack.poll());
        System.out.println(stack.size());
        System.out.println("-------------");
        System.out.println(stack.poll());
        System.out.println(stack.size());
        System.out.println("-------------");
    }
}

class StackNodeBySingleList<T> {
    public SingleNode<T> head;
    public int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T t) {
        SingleNode<T> cur = new SingleNode<>(t);
        if(head == null) {
            head = cur;
        } else {
            cur.next = head;
            head = cur;
        }

        size++;
    }

    public T poll() {
        T value = null;
        if(head != null) {
            value = head.value;
            head = head.next;
            size--;
        }

        return value;
    }

    public T peek() {
        T value = null;
        if(head != null) {
            value = head.value;
        }

        return value;
    }
}
