package com.lec.ex0;

public class scoreMain {
	public static void main(String[] args) {
		Score [] person = {new Score("���켺", 91, 90, 90),
						   new Score("���ϴ�", 90, 90, 91),
						   new Score("Ȳ����", 81, 80, 80),
						   new Score("������", 80, 80, 81),
						   new Score("������", 70, 71, 70),};
		
		System.out.println("\t\t��\t��\tǥ\t\t\t");
		System.out.println("---------------------------------------------");
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		System.out.println("---------------------------------------------");
		for(Score temp: person) {
			temp.setTot();
			temp.setAvg();
			temp.printScore();
		}
		System.out.println("---------------------------------------------");
		
		int totkor = 0, toteng = 0, totmat = 0, tottot = 0; double totavg = 0;;
		for(int i = 0;i<person.length;i++) {
			totkor += person[i].getKor();
			toteng += person[i].getEng();
			totmat += person[i].getMat();
			tottot += person[i].getTot();
			totavg += person[i].getAvg();
		}
		System.out.println("����"+"\t"+totkor+"\t"+toteng+"\t"+totmat+"\t"+tottot+"\t"+(int)totavg+"\n");
		System.out.println("���"+"\t"+totkor/5+"\t"+toteng/5+"\t"+totmat/5+"\t"+(double)tottot/5+"\t"+totavg/5.0+"\n");
		System.out.println("---------------------------------------------");
	}
}
