package junior.dailyPractice._20221220;

/**
 * 使用单链表实现队列
 */
public class PracticeQueueBySingleList {
    public static void main(String[] args) {
        QueueNodeBySingleList<Integer> queue = new QueueNodeBySingleList<>();
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        System.out.println("---------------");
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println("---------------");
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println("---------------");
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println("---------------");
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println("---------------");
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println("---------------");
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println("---------------");
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}

class QueueNodeBySingleList<T> {
    public SingleNode<T> head;
    public SingleNode<T> tail;
    public int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(T t) {
        SingleNode<T> cur = new SingleNode<>(t);
        if(tail == null) {// tail是空说明整个队列就是空的，head一定为空，只要对立中存在一个节点，那么tail就不可能为空
            head = cur;
            tail = cur;
        } else {
            tail.next = cur;
            tail = cur;
        }

        size++;
    }

    public T poll() {
        T value = null;
        if(head != null) {// 由于队列是FIFO，head是先进入的，所以从head弹出
            value = head.value;
            head = head.next;
            size--;
        }

        if(head == null) {// 避免内存泄漏
            tail = null;
        }
        return value;
    }

    public T peek() {
        T value = null;
        if(head != null) {// 由于队列是FIFO，head是先进入的，所以从head弹出
            value = head.value;
        }
        return value;
    }
}