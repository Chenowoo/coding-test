package baekjun;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		int duringtime = sc.nextInt();
		int sumtime = m+duringtime;
		int abstime = sumtime%60; // ��+�ɸ��� �ð��� 60���� ���� ������
		int divtime = sumtime/60; // ��+�ɸ��� �ð��� 60���� ���� ��
		
		if(sumtime<60) {
			System.out.println(h + " " + sumtime);
		} else if(sumtime>=60 && sumtime%60==0) { //�ɸ��� �ð� + ���� 60����� ���
			if(h+divtime>=24) {//h=22, divtime=5 sum=27-24
				System.out.println(h+divtime-24 + " " + "0");
			} else {
				System.out.println(h+divtime + " " + "0");
			}
		} else if(sumtime%60!=0) { //�ɸ��� �ð� + ���� 60����� �ƴҰ��
			if(h+divtime>=24) {
				System.out.println(h+divtime-24 + " " + abstime);
			} else {
				System.out.println(h+divtime + " " + abstime);
			}
		}
	}
}
