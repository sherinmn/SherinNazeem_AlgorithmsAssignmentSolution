package com.gl.stocker.beans;

public class Company {
	
	private double sharePrice;
	private boolean shareRise;
	
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	public boolean isShareRise() {
		return shareRise;
	}
	public void setShareRise(boolean shareRise) {
		this.shareRise = shareRise;
	}
	
	//Constructor to accept the values
	public Company(double sharePrice,boolean shareRise)
	{
		this.sharePrice=sharePrice;
		this.shareRise=shareRise;
	}
	

}
