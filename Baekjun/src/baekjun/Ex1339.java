package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex1339 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int sum = 0;
		for(int i=0; i<50; i++) {//���� ���� ����
			list.add((int)(Math.random()*50));
			sum += list.get(i);
			System.out.print(list.get(i) + " ");
		}

		int val = sum/50;
		
		System.out.println();
		System.out.println("��հ� : " + val);
		
		boolean check = false;//��հ��� ���� ���� ���ڰ� ������ false, ������ true
		for(int i : list) {
			if(i==val){
				check = true;
				System.out.println(i);
				break;
			} 
		}
		if(!check) {
			System.out.println(0);
		}
	}

}
