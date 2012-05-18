package com.vp.datastructure.linklist.doubley;

/**
 * @author ney
 *
 */
public class DoubleyLinkListUtil {
	private DoubleyLinkList head; 
	
	public DoubleyLinkListUtil() {
		head = new DoubleyLinkList();
	}
	
	public DoubleyLinkList getListHeader()
	{
		return head;
	}
	
	public DoubleyLinkList createListNode(DoubleyLinkList start)
	{
		DoubleyLinkList trackForward;
		DoubleyLinkList trackBack;
		DoubleyLinkList temp,newNode;
		
		if(start==null)
		{
			 return getListHeader();
		}
		
		if(start.getForward()==null)
		{
			newNode = new DoubleyLinkList();
			newNode.setForward(null);
			newNode.setBack(start);
			start.setForward(newNode);
		}
		else
		{
			temp = start;
			while(temp.getForward()!=null)
			{
				trackForward = temp.getForward();
				trackBack = temp.getBack();
				temp = trackForward;
			}
			
			newNode = new DoubleyLinkList();
			newNode.setForward(null);
			newNode.setBack(temp);
			temp.setForward(newNode);
		}
		return newNode;
	}
	
	
	public void insertNodeAfter(DoubleyLinkList start,String lookUp,String data)
	{
		DoubleyLinkList loc = traversForward(start, lookUp);
		DoubleyLinkList temp;
		
		try
		{
			temp = new DoubleyLinkList();
			temp.setBack(loc);
			temp.setForward(loc.getForward());
			loc.getForward().setBack(temp);
			loc.setForward(temp);
			temp.setData(data);
		}
		catch (NullPointerException npe)
		{
			System.out.println("can't find look up value in List, inserting at last location");
			createListNode(start).setData(data);
		}
	}
	/*
	 * This method will return the reference of the lookUp node;
	 */
	public DoubleyLinkList traversForward(DoubleyLinkList start,String lookUp)
	{
		if(start==null)
			return start;
		
		DoubleyLinkList temp,loc=null,ftemp;
		temp=start;
		while(temp!=null)
		{
			if(lookUp.equals(temp.getData()))
			{
				loc=temp;
				break;
			}
			
			ftemp = temp.getForward();
			temp=ftemp;
		}
		return loc;
	}
	
	
	public DoubleyLinkList traversBack(DoubleyLinkList node)
	{
		DoubleyLinkList back = null;
		while(node != null)
		{
			back = node.getBack();
			node = back;
		}
		return back;
	}
	
	public void print(DoubleyLinkList start)
	{
		System.out.println("##################################################");
		do
		{
			DoubleyLinkList list;
			
			System.out.println("Back Pointer ->"+start.getBack());
			System.out.println("Node ->"+start+" Data = "+start.getData());
			System.out.println("Forward pointe ->"+start.getForward());
			
			list = start.getForward();
			start= list;
		}
		while(start!=null);
	}
	
	public void removeListNode(DoubleyLinkList start,String lookUp)
	{
		DoubleyLinkList loc = traversForward(start, lookUp);
		DoubleyLinkList previous;
		try
		{
			previous = loc.getBack();
			previous.setForward(loc.getForward());
		}
		catch(NullPointerException npe)
		{
			System.out.println("Unable to locate " +lookUp+ " in the list with Header "+start);
		}
	}
}
