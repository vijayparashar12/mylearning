package com.vp.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	private List<T> stack;
	private int TOS = 0;

	public Stack() {
		stack = new ArrayList<T>();
	}

	public int push(T t) {
		stack.add(TOS, t);
		TOS++;
		return TOS;
	}

	public T pop() {
		T item = null;
		if (TOS != 0) {
			item = stack.get(--TOS);
			stack.remove(TOS);
		}
		return item;
	}
}
