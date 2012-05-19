package com.vp.datastructure.stack;

public class TestingGenericsStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> sI =  new Stack<Integer>();
		Stack<String> sS = new Stack<String>();
		System.out.println(sI);
		for(int i=1;i<=100;i++){
			sI.push(i);
		}
		sS.push(sI.pop().toString());
		System.out.println(sS.pop());
		System.out.println(sS);
	}

}
