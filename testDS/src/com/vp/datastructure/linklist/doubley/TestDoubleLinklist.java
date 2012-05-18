package com.vp.datastructure.linklist.doubley;

public class TestDoubleLinklist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoubleyLinkListUtil util = new DoubleyLinkListUtil();
		DoubleyLinkList start = util.getListHeader();
		DoubleyLinkList node = null;
		
		start.setData("Node - 0");
		for (int i=0;i<5;i++)
		{
			node = util.createListNode(start);
			node.setData("Node - "+(i+1));
		}
		
		util.insertNodeAfter(start, "Node - 0", "New Node");
		System.out.println("First Node Of the List ->"+start);
		util.print(start);
		
		util.removeListNode(start, "New Node");
		util.print(start);

	}

}
