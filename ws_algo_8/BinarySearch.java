package com.ssafy.algo;

public class BinarySearch<T> {
	private TreeNode<T> root;
	public static void main(String[] args) {
		BinarySearch<Integer> a=new BinarySearch<>(9);
		a.insert(4);
		a.insert(4);
		a.insert(12);
		a.insert(3);
		a.insert(6);
		a.insert(15);
		a.insert(13);
		a.insert(17);
		a.preorder();
		System.out.println(a.search(2));
		System.out.println(a.search(17));
	}
	BinarySearch(T data){
		root=new TreeNode<T>(data);
	}
	public void insert(T data) {
		TreeNode<T> newNode=new TreeNode<>(data);
		TreeNode<T> tmp=find_data(data);
		if(tmp!=null) {
			if((int)newNode.data<(int)tmp.data) {
				tmp.left=newNode;
			}else {
				tmp.right=newNode;
			}
		}else {
			System.out.println("이미 존재하는 데이터");
		}
	}
	public void delete() {
		
	}
	public TreeNode<T> find_data(T data){
		TreeNode<T> now=root;
		while(true) {
			if(data==now.data) {//equals?
				return null;
			}else if((int)data<(int)now.data) {
				if(now.left!=null) {
					now=now.left;
				}else {
					return now;
				}
			}else if((int)data>(int)now.data) {
				if(now.right!=null) {
					now=now.right;
				}else {
					return now;
				}
			}
		}
	}
	public boolean search(T data) {
		TreeNode<T> now=root;
		while(true) {
			if(data==now.data) {//equals?
				return true;
			}else if((int)data<(int)now.data) {
				if(now.left!=null) {
					now=now.left;
				}else {
					return false;
				}
			}else if((int)data>(int)now.data) {
				if(now.right!=null) {
					now=now.right;
				}else {
					return false;
				}
			}
		}
	}
	private void preorder(TreeNode<T> n) {
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
