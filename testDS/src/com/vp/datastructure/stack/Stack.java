package com.vp.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import com.vp.datastructure.tree.binary.TreeNode;

public class Stack {
	private static List<TreeNode> stack;
	private static int TOS = 0;
	private static Stack instance;

	private Stack() {
		stack = new ArrayList<TreeNode>();
		// Stack instance = new Stack();
	}

	public static Stack getInstance() {
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
