package junior.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 反转双向链表
 *
 * 思路：
 * 关键点：
 * 1、构造一个单链表
 * 2、记录pre，head（也就是当前节点），next
 * 3、返回翻转后的头节点
 *
 * @author zhangzhiwang
 * @date 2022年1月20日 下午5:48:36
 */
public class ReverseDoubleList {
	public static void main(String[] args) {
		// 构造双向链表
		Node node1 = new Node("node_1");
		Node node2 = new Node("node_2");
		Node node3 = new Node("node_3");
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setPre(node2);
		node2.setPre(node1);
		
		System.out.println("打印原始链表：");
		System.out.println(node1);
		System.out.println(node1.next);
		System.out.println(node1.next.next);
		System.out.println("---------------");
		System.out.println(node3.pre);
		System.out.println(node3.pre.pre);
		System.out.println("================");
		
		node1 = reverseDoubleList(node1);
		System.out.println("反转之后：");
		System.out.println(node1);
		System.out.println(node1.next);
		System.out.println(node1.next.next);
		System.out.println("---------------");
		System.out.println(node1.next.next.pre);
		System.out.println(node1.next.pre);
		System.out.println(node1.pre);
		System.out.println("---------------");
	}
	
	@Data
	@RequiredArgsConstructor
	static class Node {
		@NonNull
		private String value;
		private Node pre;
		private Node next;
		
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}
	
	/**
	 * 反转双向链表
	 * 
	 * @param head 传入原始链表的头部节点
	 * @return 返回反转后的链表的头部节点
	 * @author zhangzhiwang
	 * @date 2022年1月20日 下午6:39:28
	 */
	public static Node reverseDoubleList(Node head) {
		/**
		 * 	<-  1 => 2 => 3 => null
		 *    	       
		 *    	                 h
		 *                       n
		 *           		p
		 */
		Node pre = null;
		Node next = null;
		while(head != null) {
			next = head.next;// 在断开链接前保存next以防断开之后找不到了
			head.next = pre;
			head.pre = next;
			pre = head;
			head = next;
		}
		
		return pre;
	}
}
