package com.vp.datastructure.linklist.doubley;

public class DoubleyLinkList {
	private String data;
	private DoubleyLinkList forward;
	private DoubleyLinkList back;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public DoubleyLinkList getForward() {
		return forward;
	}
	public void setForward(DoubleyLinkList forward) {
		this.forward = forward;
	}
	public DoubleyLinkList getBack() {
		return back;
	}
	public void setBack(DoubleyLinkList back) {
		this.back = back;
	}

}
