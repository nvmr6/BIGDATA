package com.lec.customer;

public class CustomerDto {
	private int cId;
	private String cTel;
	private String cName;
	private int cPoint;
	private int cAmount;
	private String levelName;
	private int forLevelup;

	public CustomerDto(String cTel, String cName) {
		this.cTel = cTel;
		this.cName = cName;
	}

	public CustomerDto(int cId, String cTel, String cName) {
		this.cId = cId;
		this.cTel = cTel;
		this.cName = cName;
	}

	public CustomerDto(int cId, String cTel, String cName, int cPoint, int cAmount, String levelName, int forLevelup) {
		this.cId = cId;
		this.cTel = cTel;
		this.cName = cName;
		this.cPoint = cPoint;
		this.cAmount = cAmount;
		this.levelName = levelName;
		this.forLevelup = forLevelup;
	}

	@Override
	public String toString() {
		return cId + "\t" + cTel + "\t" + cName + "\t" + cPoint + "\t" + cAmount + "\t" + levelName + "\t" + forLevelup;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcPoint() {
		return cPoint;
	}

	public void setcPoint(int cPoint) {
		this.cPoint = cPoint;
	}

	public int getcAmount() {
		return cAmount;
	}

	public void setcAmount(int cAmount) {
		this.cAmount = cAmount;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getForLevelup() {
		return forLevelup;
	}

	public void setForLevelup(int forLevelup) {
		this.forLevelup = forLevelup;
	}
}
