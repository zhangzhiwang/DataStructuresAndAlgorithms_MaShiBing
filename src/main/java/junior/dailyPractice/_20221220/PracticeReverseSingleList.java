package junior.dailyPractice._20221220;

/**
 * 翻转单链表
 */
public class PracticeReverseSingleList {
    public static void main(String[] args) {
        SingleNode<Integer> n1 = new SingleNode<>(1);
        SingleNode<Integer> n2 = new SingleNode<>(2);
        SingleNode<Integer> n3 = new SingleNode<>(3);
        SingleNode<Integer> n4 = new SingleNode<>(4);
        SingleNode<Integer> n5 = new SingleNode<>(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next=n5;

        System.out.print(n1.value);
        System.out.print("\t" + n1.next.value);
        System.out.print("\t" + n1.next.next.value);
        System.out.print("\t" + n1.next.next.next.value);
        System.out.print("\t" + n1.next.next.next.next.value);
        System.out.println();
    }


}

/**
 * 单链表节点
 */
class SingleNode<T> {
    public T value;
    public SingleNode<T> next;

    public SingleNode(T t) {
        value = t;
    }
}
