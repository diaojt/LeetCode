package 链表;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _23_合并多个有序链表 {
	
	/**
	 * 	思路5：分治策略：O(nlogk)
	 */
	public ListNode mergeKLists5(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		int step = 1;
		while (step < lists.length) {
			int nextStep = step << 1;
			for (int i=0; i+step < lists.length; i += nextStep){
				lists[i] = mergeTwoLists1(lists[i], lists[i+step]);
			} 
			step = nextStep;
		}
		return lists[0];
	}
	
	/**
	 * 	思路4：优先级队列（小顶堆）
	 */
	public ListNode mergeKLists4(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		
		ListNode head = new ListNode(0);
		ListNode cur = head;
		
		// 将所有链表的头节点添加到小顶堆（优先级队列）中
		PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode node1, ListNode node2)-> {
			return node1.val - node2.val;
		});
		
		for (ListNode list : lists) {
			if (list == null) continue;
			queue.offer(list);
		}
		
		// 不断删除堆顶元素，并且把堆顶元素的next添加到堆中
		while (!queue.isEmpty()) {
			// 删除堆顶元素
			ListNode node = queue.poll();
			cur = cur.next = node;
			if (node.next != null) {
				queue.offer(node.next);
			}
		}
		
		return head.next;
	}
	
	// 虚拟头结点（dummy head）
	ListNode head = new ListNode(0);
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		head.next = null; //没必要每次都创建虚拟头结点
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
	
	/**
	 * 	思路3：逐一两两合并
	 */
	public ListNode mergeKLists3(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		for (int i = 1; i < lists.length; i++) {
			lists[0] = mergeTwoLists1(lists[0], lists[i]);
		}
		return lists[0];
	}
	
	/**
	 * 	思路2：逐一比较
	 */
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while (true) {
			// 最小聊表节点所在的索引
			int minIndex = -1;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] == null) continue;
				if (minIndex == -1 || lists[i].val < lists[minIndex].val) {
					minIndex = i;
				}
			}
			
			// 所有链表节点已经串起来了
			if (minIndex == -1) break;
			cur = cur.next = lists[minIndex];
			lists[minIndex] = lists[minIndex].next;
		}
		return head.next;
	}
	
	
	/**
	 * 	思路1：最笨的解法 时间复杂度O(nlogn)，空间复杂度O(n)
	 */
	public ListNode mergeKLists1(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		// 将所有节点添加到数组中
		List<ListNode> nodes = new ArrayList<>();
		for (ListNode list : lists) {
			while (list != null) {
				nodes.add(list);
				list = list.next;				
			}
		}
		
		// 对数组进行排序（基于比较的排序，时间复杂度目前最好的是O(nlogn)，n是所有节点的数量）
		nodes.sort((ListNode node1, ListNode node2) ->{
			return node1.val - node2.val;
		});
		// 将排好序的节点串起来
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for (ListNode node : nodes) {
			cur.next = node;
			cur = cur.next;
		}
		
		return head.next;
	}
}
