package com.vp.datastructure.tree.binary;

import java.util.ArrayList;

//this is a singleton stack

public class Stack {
	private static ArrayList<TreeNode> stack;
	private static int TOS = 0;
	private static Stack instance;

	private Stack() {
		stack = new ArrayList<TreeNode>();
		// Stack instance = new Stack();
	}

	public static Stack getInstance() {
		if (instance == null)
			instance = new Stack();

		return instance;
	}

	public int push(TreeNode t) {
		stack.add(TOS, t);
		TOS++;
		return TOS;
	}

	public TreeNode pop() {
		TreeNode item = null;
		if (TOS != 0) {
			item = stack.get(--TOS);
			stack.remove(TOS);
		}
		return item;
	}
}
