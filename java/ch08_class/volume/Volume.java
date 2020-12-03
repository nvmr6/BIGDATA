package com.lec.volume;
/*������ü ���� / ���� ���Ŭ���� = 
 *  ������: ���� width, ���� height, ���� depth
 *  �޼ҵ�: ���� (void calNsetVolume(int width, int height, int depth)
 */
public class Volume {
	private int width;
	private int height;
	private int depth;
	private int volume;
	private int area;
	
	public Volume() {}
	public Volume(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public Volume(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}	
	public void calNsetVolume() {
		if(depth!=0) {
			volume = width*height*depth;
		}else {
			area = width*height;
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		 this.width = width;
	}
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		 this.height = height;
	}
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		 this.depth = depth;
	}
	public int getVolume() {
		return volume;
	}
	public int getArea() {
		return area;
	}
}
