package junior.list;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 用单链表实现栈
 *
 * 关键点：
 * 栈的类里面只要有一个head链表节点即可
 *
 * @author zhangzhiwang
 * @date 2022年1月20日 下午9:47:17
 */
public class StackBySingleList {
	public static void main(String[] args) {
		MyStack<Integer> myStack = new MyStack<>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		System.out.println(myStack.getSize());
		
		Integer result1 = myStack.pop();
		System.out.println("result = " + result1);
		System.out.println("size = " + myStack.getSize());
		Integer result2 = myStack.pop();
		System.out.println("result = " + result2);
		System.out.println("size = " + myStack.getSize());
		Integer peek = myStack.peek();
		System.out.println("peek = " + peek);
		
		Integer result3 = myStack.pop();
		System.out.println("result = " + result3);
		System.out.println("size = " + myStack.getSize());
		
	}
	
	@RequiredArgsConstructor
	static class Node<V> {
		@NonNull
		private V value;
		private Node<V> next;
	}
	
	static class MyStack<V> {
		private Node<V> head;// 注意：由于栈结构是先进后出，所以在栈的结构体里面维护一个变量head就可以完成操作。
		private int size;
		
		public MyStack() {
			head = null;
			size = 0;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public int getSize() {
			return size;
		}
		
		public void push(V value) {
			Node cur = new Node(value);
			if(head == null) {
				head = cur;
			} else {
				cur.next = head;
				head = cur;
			}
			
			size++;
		}
		
		public V pop() {
			if(head == null) {
				return null;
			}
			
			V result = head.value;
			head = head.next;
			size--;
			
			return result;
		}
		
		public V peek() {
			if(head == null) {
				return null;
			}
			
			V result = head.value;
			return result;
		}
	}
}
