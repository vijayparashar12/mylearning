package com.vp.datastructure.linklist.oneway;

public class LinkList {
	private Node start;
	private int size;
	public LinkList()
	{
		start = new Node();
		size++;
	}
	public Node getListHeader()
	{
		return start;
	}
	public int size()
	{
		return size;
	}
	public Node add(Node start)
	{
		Node loc=null;
		Node newNode= null;
		if(start == null)
		{
			return getListHeader();
		}
		if(start.getNext()==null)
		{
			 newNode= new Node();
			start.setNext(newNode);
			size++;
			return newNode;
		}
		else
		{
			while(start!=null)
			{
				loc=start.getNext();
				start = loc;
			}
		}
		
		newNode = new Node();
		loc.setNext(newNode);
		size++;
		return newNode;
	}
	public Node add(Node start,String lookUp)
	{
		Node loc = find(start, lookUp);
		
		if(loc==null)
			return add(start);
		
		Node newNode = new Node();
		newNode.setNext(loc.getNext());
		loc.setNext(newNode);
		size++;
		return newNode;
	}
	
	public Node add(Node start,int index)
	{
		if(start == null && index ==0)
		{
			return getListHeader();
		}
		else if(index==size+1)
		{
			return add(start);
		}
		else if(start ==null)
		{
		}
		return start;
	}
	
	public Node find(Node start,String lookUp)
	{
		Node loc = null;
		while(start!=null)
		{
			if(lookUp.equals(start.getData()))
			{
				loc = start;
				break;
			}
			loc = start.getNext();
			start = loc;
		}
		
		return loc;
	}

}
