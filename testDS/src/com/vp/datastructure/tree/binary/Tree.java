package com.vp.datastructure.tree.binary;

public class Tree {
	private TreeNode root;
	private Stack stack;
	
	public Tree(){
		stack =Stack.getInstance();
	}
	public TreeNode initTree(int[] data) {
		if (root != null) {
			System.out.println("tree Alredy initlized");
			return root;
		}
		root = new TreeNode();
		int currData = data[0];
		root.setData(currData);
		TreeNode currNode = root;
		TreeNode parentNode = null;

		for (int i = 1; i < data.length; i++) {
			while (currNode != null) {
				if (currNode.getData() < data[i]) {
					parentNode = currNode;
					currNode = currNode.getRight();
				} else {
					parentNode = currNode;
					currNode = currNode.getLeft();
				}
			}
			if (parentNode.getData() < data[i]) {
				parentNode.setRight(new TreeNode());
				parentNode.getRight().setData(data[i]);
			} else {
				parentNode.setLeft(new TreeNode());
				parentNode.getLeft().setData(data[i]);
			}
			currNode = root;
		}

		return root;
	}

	public TreeNode initTree(int data) {
		if (root != null) {
			System.out.println("Tree Alredy initlized");
			return root;
		}
		root = new TreeNode();
		int currData = data;
		root.setData(currData);
		return root;
	}

	public TreeNode insert(int data) {
		if (root == null) {
			System.out.println("Tree not intilized,calling init method");
			int[] dataArray = new int[1];
			dataArray[0] = data;
			return initTree(dataArray);
		}
		TreeNode currNode = root;
		TreeNode parentNode = null;
		while (currNode != null) {
			if (currNode.getData() < data) {
				parentNode = currNode;
				currNode = currNode.getRight();
			} else {
				parentNode = currNode;
				currNode = currNode.getLeft();
			}
		}
		if (parentNode.getData() < data) {
			parentNode.setRight(new TreeNode());
			parentNode.getRight().setData(data);
		} else {
			parentNode.setLeft(new TreeNode());
			parentNode.getLeft().setData(data);
		}
		return root;
	}

	public void traversPreOrder() {
		TreeNode currNode = root;
		//Stack stack = Stack.getInstance();
		System.out.println("-------------------------------------------");
		System.out.println("-------------Pre Order Traversal-----------");
		System.out.println("-------------------------------------------");
		while (currNode != null) {
			System.out.println(currNode);
			if (currNode.getRight() != null) {
				stack.push(currNode.getRight());
			}
			if (currNode.getLeft() != null) {
				currNode = currNode.getLeft();
			} else {
				currNode = stack.pop();
			}
		}
		System.out.println("-------------------xxxxx-------------------");
	}

	public void traversInOrder() {
		TreeNode currNode = root;
		//Stack stack = Stack.getInstance();
		pushToStack(currNode);
		currNode = stack.pop();
		System.out.println("-------------------------------------------");
		System.out.println("--------------In Order Traversal-----------");
		System.out.println("-------------------------------------------");
		while (currNode != null) {
			System.out.println(currNode);

			if (currNode.getRight() != null) {
				currNode = currNode.getRight();
				pushToStack(currNode);
			}
			currNode = stack.pop();
		}
		System.out.println("-------------------xxxxx-------------------");
	}

	// this is a recursive solution
	public void traversPostOrder(){
		traversPostOrder(root);
	}
	private void traversPostOrder(TreeNode root) {
		TreeNode currNode = root;
		if (currNode != null) {
			traversPostOrder(currNode.getLeft());
			traversPostOrder(currNode.getRight());
			System.out.println(currNode);
		}
	}

	private void pushToStack(TreeNode node) {
		while (node != null) {
			stack.push(node);
			//Stack.getInstance().push(node);
			node = node.getLeft();
		}
	}

	public boolean search(int lookUp) {
		TreeNode currNode = root;
		int data;
		while (currNode != null) {
			data = currNode.getData();
			if (lookUp == data) {
				return true;
			} else if (lookUp > data) {
				currNode = currNode.getRight();
			} else {
				currNode = currNode.getLeft();
			}
		}
		return false;
	}

	public int size() {
		int count = 0;
		TreeNode currNode = root;
		while (currNode != null) {
			count++;
			if (currNode.getRight() != null) {
				stack.push(currNode.getRight());
			}
			if (currNode.getLeft() != null) {
				currNode = currNode.getLeft();
			} else {
				currNode = stack.pop();
			}
		}
		return count;
	}
	
	public int countLeafNode(){
		 return countLeafNode(root);
	}
	private int countLeafNode(TreeNode root) {
		TreeNode currNode = root;
		int leaf = 0;
		if (currNode != null) {
			if (currNode.getLeft() == null && currNode.getRight() == null) {
				leaf++;
			} else {
				leaf = leaf + countLeafNode(currNode.getLeft());
				leaf = leaf + countLeafNode(currNode.getRight());
			}
		}
		return leaf;
	}

	public int height() {
		return height(root);
	}
	
	private int height(TreeNode root){
		if(root.isLeafNode()){
			return 1;
		}else {
			int lth = 0;
			int rth = 0;
			if(root.getLeft()!=null){
				lth=height(root.getLeft());
			} 
			if(root.getRight()!=null){
				rth = height(root.getRight());
			}
			return 1+max(lth,rth);
		}
	}
	
	public int max(int a,int b){
		if(a>b){
			return a;
		} else {
			return b;
		}
	}
	public boolean delete(int item) {
		TreeNode currNode = root;
		TreeNode parent = null;

		while (currNode != null) {
			if (currNode.getData() == item) {
				break;
			} else if (currNode.getData() < item) {
				parent = currNode;
				currNode = currNode.getRight();
			} else {
				parent = currNode;
				currNode = currNode.getLeft();
			}
		}
		if (currNode == null) {
			return false;
		} else {
			if (currNode.getLeft() != null && currNode.getRight() != null) {
				return deleteTwoChildNode( currNode);
			} else {
				return deleteNode(currNode, parent);
			}
		}
	}

	/*
	 * 1.Checking whether Node is right or a left child of parent 2.check for
	 * whether node has child or not 3.parent's right or left child(result of
	 * step 1) should be modified with node's child or null
	 */
	private boolean deleteNode(TreeNode node, TreeNode parent) {
		try {
			if (parent.getRight() == node) {
				if (node.hasChild()) {
					if (node.getRight() != null) {
						parent.setRight(node.getRight());
					} else {
						parent.setRight(node.getLeft());
					}
				} else {
					parent.setRight(null);
				}
			} else {
				if (node.hasChild()) {
					if (node.getRight() != null) {
						parent.setLeft(node.getRight());
					} else {
						parent.setLeft(node.getLeft());
					}
				} else {
					parent.setLeft(null);
				}
			}
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	private boolean deleteTwoChildNode(TreeNode node) {
		TreeNode inOrderSuccessor = null;
		TreeNode temp = null;
		try {
			inOrderSuccessor = getInOrderSuccessor(node.getRight());
			temp = getParent(node, inOrderSuccessor.getData());
			node.setData(inOrderSuccessor.getData());
			deleteNode(inOrderSuccessor, temp);
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	private TreeNode getInOrderSuccessor(TreeNode node) {
		pushToStack(node);
		return stack.pop();
	}

	public TreeNode getParent(TreeNode root, int item) {
		TreeNode currNode = root;
		TreeNode parent = null;
		try {
			while (currNode != null) {
				if (currNode.getData() == item) {
					break;
				} else if (currNode.getData() < item) {
					parent = currNode;
					currNode = currNode.getRight();
				} else {
					parent = currNode;
					currNode = currNode.getLeft();
				}
			}
		} catch (NullPointerException e) {
			return null;
		}
		return parent;
	}
	
	public TreeNode getParent(int item) {
		TreeNode currNode = root;
		TreeNode parent = null;
		try {
			while (currNode != null) {
				if (currNode.getData() == item) {
					break;
				} else if (currNode.getData() < item) {
					parent = currNode;
					currNode = currNode.getRight();
				} else {
					parent = currNode;
					currNode = currNode.getLeft();
				}
			}
		} catch (NullPointerException e) {
			return null;
		}
		return parent;
	}
}
