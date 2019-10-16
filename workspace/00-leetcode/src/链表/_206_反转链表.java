package 链表;


/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author diaojt
 *
 */
public class _206_反转链表 {

	public ListNode reverseList(ListNode head) {
		
		
		/*
		 * 递归实现
		 */
//		//if (head == null) return null;
//		//if (head.next == null) return head;
//		if (head == null || head.next == null) return head;
//		ListNode newHead  = reverseList(head.next);
//		head.next.next = head;
//		head.next = null;
//        return newHead;
//        
		
		/*
		 * 非递归实现
		 */
		if (head == null || head.next == null) return head;
		ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		
		return newHead;
  
    }       
       
}
