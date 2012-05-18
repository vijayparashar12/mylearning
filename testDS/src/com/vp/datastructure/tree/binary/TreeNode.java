package com.vp.datastructure.tree.binary;

public class TreeNode {
	private TreeNode left;
	private int data;
	private TreeNode right;

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Data -"+this.getData());
		sb.append(" \t Left -");
		sb.append(this.getLeft() == null ? "x" : this.getLeft().getData());
		sb.append(" \t Right -");
		sb.append(this.getRight() == null ? "x" : this.getRight().getData());
		return sb.toString();
	}
	
	public boolean hasChild() {
		if (this.right != null || this.left != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isLeafNode() {
		return(!hasChild());
	}

}
