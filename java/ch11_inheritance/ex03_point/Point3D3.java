package com.lec.ex03_point;

public class Point3D3 extends Point3{
	private int z;
	public void point3Dprint() {
		System.out.println("3차원 좌표: "+getX()+","+getY()+","+z);
	}
	public String point3DInfoString() {
		return "3차원 좌표: "+getX()+","+getY()+","+z;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
