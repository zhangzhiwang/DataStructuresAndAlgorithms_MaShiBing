package junior.dailyPractice._20221220;

/**
 * 双链表翻转
 */
public class PracticeReverseDoubleList {
    public static void main(String[] args) {
        DoubleNode<Integer> n1 = new DoubleNode<>(1);
        DoubleNode<Integer> n2 = new DoubleNode<>(2);
        DoubleNode<Integer> n3 = new DoubleNode<>(3);
        DoubleNode<Integer> n4 = new DoubleNode<>(4);
        DoubleNode<Integer> n5 = new DoubleNode<>(5);
        n1.next = n2;
        n2.last = n1;
        n2.next = n3;
        n3.last = n2;
        n3.next = n4;
        n4.last = n3;
        n4.next = n5;
        n5.last = n4;

        printDoubleList(n1);
        System.out.println("------------");
        DoubleNode<Integer> newHead = reverseDoubleList(n1);
        printDoubleList(newHead);
    }

    private static <T> DoubleNode<T> reverseDoubleList(DoubleNode<T> head) {
        if(head == null || head.next == null) {
            return head;
        }

        DoubleNode<T> pre = null;
        DoubleNode<T> next = head;
        while(head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static <T> void printDoubleList(DoubleNode<T> head) {
        System.out.println("正序：");
        DoubleNode tail = null;
        while(head != null) {
            System.out.print(head.value + (head.next == null ? "" : " -> "));
            if(head.next == null) {
                tail = head;
            }
            head = head.next;
        }
        System.out.println();
        System.out.println("倒序：");
        while(tail != null) {
            System.out.print(tail.value + (tail.last == null ? "" : " => "));
            tail = tail.last;
        }
        System.out.println();
    }
}

class DoubleNode<T> {
    public T value;
    public DoubleNode<T> last;
    public DoubleNode<T> next;

    public DoubleNode(T t) {
        value = t;
    }
}
