package com.vp.datastructure.tree.binary;

import java.util.Date;
import java.util.Random;

public class TestBinaryTree {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Tree binaryTree = new Tree();
		int[] treeData = { 10, 7, 12, 2, 5, 13, 9, 16, 4, 11 };
		System.out.println("10,7,12,2,5,13,9,16,4,11");
		TreeNode root = binaryTree.initTree(treeData);
		binaryTree.insert(3);
		binaryTree.insert(15);
		binaryTree.insert(1);
		binaryTree.insert(8);
		binaryTree.insert(6);
		binaryTree.insert(14);
		binaryTree.insert(17);
		binaryTree.insert(18);
		binaryTree.insert(19);
		binaryTree.insert(20);
		binaryTree.traversPreOrder();
		binaryTree.traversInOrder();
		binaryTree.traversPostOrder();
		System.out.println(binaryTree.search( 12));
		System.out.println(binaryTree.search( 100));
		System.out.println(root);
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
		System.out.println("New solution height"+binaryTree.getHeight());
		System.out.println("---vv---"+binaryTree.diameter());
		*/
		  Tree tree = new Tree(); 
		  /*int [] treedata1 = {5,7,10,3,11,2,4,1}; 
		  tree.initTree(treedata1);
		  System.out.println(tree.countLeafNode());
		  long l1=new Date().getTime();
		  System.out.println(tree.height());
		  long l2 = new Date().getTime();
		  System.out.println(l2-l1);
		  System.out.println("Tree diameter"+tree.diameter());
		  l1=new Date().getTime();
		  System.out.println(tree.getHeight());
		  l2=new Date().getTime();
		  System.out.println(l2-l1);*/
		  insertMillionRecord(tree); 
	}
	
	public static void insertMillionRecord(Tree tree){
		Random r = new Random();
		
		for(int i=0 ;i<5000000; i++){
		int a = r.nextInt(10000000);
		tree.insert(a);		
		}
		System.out.println(tree.countLeafNode());
		//System.out.println(tree.diameter());
		long l1=new Date().getTime();
		int h1=tree.height();	
		long l2=new Date().getTime();
		int h2=tree.getHeight();
		long l3=new Date().getTime();
		System.out.println("H1:"+h1+"\nH2:"+h2);
		System.out.println(l2-l1);
		System.out.println(l3-l2);
		//System.out.println("test"+ a);
	}
}
