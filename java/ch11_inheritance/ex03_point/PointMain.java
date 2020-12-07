package com.lec.ex03_point;

public class PointMain {
	public static void main(String[] args) {
		Point3 point = new Point3();
		point.setX(5);
		point.setY(6);
		point.pointprint();
		System.out.println(point.pointInfoString());
		
		Point3D3 point3D = new Point3D3();
		point3D.setX(5);
		point3D.setY(6);
		point3D.setZ(7);
		point3D.point3Dprint();
		System.out.println(point3D.point3DInfoString());
	}
}
