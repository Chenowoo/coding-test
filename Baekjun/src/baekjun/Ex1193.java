package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1193 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int sum = 1;
		int count = 2;
		
		if(num==1) {
			System.out.println("1/1");
		} else {
			while(true) {
				if(num>sum && num<=sum + count) { //num=9�� ��, 
					if(count%2==0) { //num�� ¦���� ��� �Ʒ���
						System.out.println((num-sum) + "/" + (count-(num-sum)+1));
						break;
					} else { //num�� Ȧ���� ��� ���� num=13
						System.out.println((count-(num-sum)+1) + "/" + (num-sum));
						break;
					}
				} else {
					sum += count;
					count++;
				}
			}
		}
	}

}
