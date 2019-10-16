package com.diaojt;


public class LinkList<E> extends AbstractList<E>{

	private Node<E> first;
	
	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
			
		}
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
	}


	@Override
	public E get(int index) {
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E oldElement = node.element;
		node.element = element;
		return oldElement;
	}

	@Override
	public void add(int index, E element) {
		if (index == 0) {
		  first = new Node<>(element, first);
		}else {
			Node<E> prevNode = node(index -1);
			prevNode.next = new Node<>(element, prevNode.next);
		}
		size ++;
	}

	@Override
	public E remove(int index) {
		Node<E> node = first;
		if (index == 0) {
			first = first.next;
			
		}else {
			Node<E> preNode = node(index -1);//被删除前一个节点
			node = preNode.next;//被删除节点
			preNode.next = node.next;
		}
		size--;
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.next;
			}
		}else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	
	/**
	 * 获取index位置对应的节点对象
	 * @param index
	 * @return
	 */
	private Node<E> node(int index){
		rangeCheck(index);
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(node.element);
			node = node.next;
		}
		
		string.append("]");
		return string.toString();
		
	}
}
