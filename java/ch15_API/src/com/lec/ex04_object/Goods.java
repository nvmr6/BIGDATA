package com.lec.ex04_object;

public class Goods {
	private String goodsCode;
	private String goodsName;
	private int goodsPrice;
	private int stockNum;
	public Goods(String goodsCode, String goodsName, int goodsPrice, int stockNum) {
		super();
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.stockNum = stockNum;
	}
	@Override
	public String toString() {
		String result = goodsName +"("+goodsCode+") "+goodsPrice+"원 "+stockNum+"개";
		return result;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getStockNum() {
		return stockNum;
	}
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	
}
