package com.ssafy.algo;

import com.ssafy.algo.BinarySearch.TreeNode;

public class MaxHeap<E> {
	private TreeNode<E> root;
	//root보다 큰 값이 입력되는 경우
	//
	private Node top;
	private int index=1;
	public static void main(String[] args) {
		MaxHeap<Integer> a=new MaxHeap<>(20);
		a.insert(15);
		a.insert(19);
		a.insert(4);
		a.insert(13);
		
		a.insert(11);
		a.insert(23);
		a.insert(17);
		
		a.preorder();
		//System.out.println(a.search(2));
		//System.out.println(a.search(17));
	}
	MaxHeap(E data){
		root=new TreeNode<E>(data);
		top=new Node(0);
	}
	
	public void insert(E data) {
		index++;
		//부모 노드 찾아야함//1 left 2 right
		TreeNode<E> now=root;
		int k=index;
		int count=0;
		//System.out.println(data+" 현재 데이터");
		while(k>1) {
			if(k%2==0) {
				push(2);
			}else {
				push(1);
			}
			k=k/2;
			count++;
		}
		System.out.println();
		//바꿔야할 숫자 찾은 경우 그 숫자부터 끝까지 밀어내야함
		E kk=data;//현재 데이터
		while(count>1) {
			//System.out.println(now.data);
			int a=pop();
			if((int)now.data<(int)kk) {
				E tmp=now.data;
				now.data=kk;
				kk=tmp;
				System.out.println(kk+"kk"+count);
			}
			
			if(a==2) {
				now=now.left;
			}else {
				now=now.right;
			}		
			count--;
		}
		if((int)now.data<(int)kk) {
			E tmp=now.data;
			now.data=kk;
			kk=tmp;
		}
		TreeNode<E> newNode=new TreeNode<>(kk);
		int ss=pop();
		//System.out.println(now.data+" 데이터 밑에 들어감"+ss);
		if(ss==2) {
			now.left=newNode;
		}else if(ss==1){
			now.right=newNode;
		}
		
	}
	public E delete() {//미완성
		E tmp=root.data;
		//index값 찾아서 root에 올림.
		//
		int k=index;
		int count=0;
		//System.out.println(data+" 현재 데이터");
		while(k>1) {
			if(k%2==0) {
				push(2);
			}else {
				push(1);
			}
			k=k/2;
			count++;
		}
		TreeNode<E> now=root;
		
		while(count>0) {
			int a=pop();
			if(a==2) {
				now=now.left;
			}else {
				now=now.right;
			}		
			count--;
		}
		root.data=now.data;//
		now=null;
		now=root;
		E kk;
		
		if((int)now.left.data<(int)now.right.data) {
			kk=now.right.data;
			E t=now.data;
			now.data=kk;
			kk=t;
		}else {
			kk=now.left.data;
			E t=now.data;
			now.data=kk;
			kk=t;
		}
		return tmp;
	}

	private void preorder(TreeNode<E> n) {
		System.out.print(n.data+" ");
		if (n.left != null) {
			preorder(n.left);
		}
		if (n.right != null) {
			preorder(n.right);
		}
	}
	public void preorder() {
		preorder(root);
		System.out.println();
	}
	
	
	
	private void push(int data) {
		Node newNode=new Node(data);
		
		newNode.nextNode=top.nextNode;
		top.nextNode=newNode;
		
	}
	private int pop() {
		if(top.nextNode==null) {
			return -1;
		}
		int tmp=top.nextNode.data;
		top.nextNode=top.nextNode.nextNode;
		return tmp;
	}
	private boolean isEmpty() {
		if(top.nextNode==null) {
			return true;
		}
		return false;
	}
	private class Node{
		private Node nextNode;
		private int data;
		Node(int data){
			this.data=data;
			nextNode=null;
		}
	}
	
	public class TreeNode<E> {
		E data;
		TreeNode<E> left;
		TreeNode<E> right;

		TreeNode(E data) {
			this.data = data;
			left = null;
			right = null;

		}
	}
}
