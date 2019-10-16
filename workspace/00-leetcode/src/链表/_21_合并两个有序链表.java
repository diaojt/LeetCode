package 链表;

import java.util.Currency;

public class _21_合并两个有序链表 {
	// 迭代
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		// 头结点
//		ListNode head;
//		if (l1.val <= l2.val) {
//			head = l1;
//			l1 = l1.next;
//		}else {
//			head = l2;
//			l2 = l2.next;
//		}
		// 虚拟头结点（dummy head）
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while(l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				cur = cur.next;
				l1 = l1.next;
			}else {
				cur.next = l2;
				cur = cur.next;
				l2 = l2.next;
			}
		}
		
		if (l1 == null) {
			cur.next = l2;
		}else if (l2 == null) {
			cur.next = l1;
		}
		
		return head.next;
		
	}
	
	
	// 递归
	// 只要是递归，首先要搞清楚一个问题：这个递归函数的功能是什么？
	// 递归基：边界
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		if (l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
		
		}
}
