package com.vp.datastructure.tree.binary;

public class TestBinaryTree {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree binaryTree = new Tree();
		int[] treeData = { 10, 7, 12, 2, 5, 13, 9, 16, 4, 11 };
		System.out.println("10,7,12,2,5,13,9,16,4,11");
		TreeNode root = binaryTree.initTree(treeData);
		binaryTree.insert(3);
		binaryTree.insert(15);
		binaryTree.insert(1);
		binaryTree.insert(8);
		binaryTree.insert(6);
		binaryTree.insert(14);
		binaryTree.traversPreOrder();
		binaryTree.traversInOrder();
		binaryTree.traversPostOrder();
		System.out.println(binaryTree.search( 12));
		System.out.println(binaryTree.search( 100));
		System.out.println(root);
		// TreeNode root1 = binaryTree.initTree(treeData);
		// System.out.println(root1);
		System.out.println("size \t" + binaryTree.size());
		System.out.println("Number of Leaf Node's\t"
				+ binaryTree.countLeafNode());
		System.out.println(binaryTree.height());
		System.out.println(binaryTree.delete(3));
		binaryTree.delete(14);
		binaryTree.delete(10);
		binaryTree.delete(11);
		binaryTree.traversPreOrder();
		//System.out.println(binaryTree.getParent(11));
		System.out.println("Get Tree Hight"+binaryTree.height());
		
		  Tree tree = new Tree(); 
		  int [] treedata1 = {5,7,10,3,11,2,4,1}; 
		  tree.initTree(treedata1);
		  System.out.println(tree.countLeafNode());
		  System.out.println(tree.height());
		 
	}

}
