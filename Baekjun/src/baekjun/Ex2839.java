package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2839 {

	public static void main(String[] args) throws IOException{
		/*//5�� ���� ��
		//�־��� ���� 5�� �������� ��� -> ��� ���
		//1. �������� 3���� ������ ���� ��� -> ��� ���
		//1-1. 3���� ������ �� �� �������� 3���� ������ ���� �ʴ°��
		//1-1-1. �־��� ���� 3�� ��� ���� Ȯ�� -> ��� ��� 
		//1-1-2. �־��� ���� 3�� ����� �ƴ϶�� -> -1���
		//3���� ���� ��(5���� ���� ���� ���)
		//2. �־��� ���� 3���� �������� ��� -> ��� ���
		//3. �־��� ���� 3���� ������ ���� �ʴ� ��� -> -1���
		//4. 3���� ������ �� �� �������� 3���� ������ ���� �ʴ� ��� -> -1 ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		
		if(num >= 5) { //num�� 5���� Ŭ ���
			if(num%5==0) { //5�� �������� ���
				sum = num/5;
				System.out.println(sum);
			} else if(num%5!=0){ //5�� ���� �� �������� �������
				sum = num/5;
				if((num%5)%3==0) { //5�� ���� �� �������� 3���� ���������� ���
					sum += (num%5)/3;
					System.out.println(sum);
				} else { //5�� ���� �� �������� 3���� ���������� �ʴ� ���
					if(num%3==0) { //�־��� ���� 3�� ����� ���
						sum = num/3;
						System.out.println(sum);
					} else { 
						if(num%3!=0) { //�־��� ���� 3�� ����� �ƴ϶��
							for(int i=1; i<5; i++) {
								if((num-(3*i))>0 && (num-(3*i))%5==0) {
									sum = i + ((num-(3*i))/5);
									break;
								} else {
									sum = -1;
								}
							}
						}
						System.out.println(sum);
					}
				}
			}
		}
		 else { //num�� 5���� ���� ���
			if(num%3==0) { //3�� ����� ���
				sum = num/3;
				System.out.println(sum);
			} else { //3�� ����� �ƴ� ���
				System.out.println(-1);
			}
		}*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		if(num == 4 || num == 7 ) {
			System.out.println(-1);
		} else if(num%5==0) {
			System.out.println(num/5);
		} else if(num%5==1 || num%5==3) {
			System.out.println((num/5) + 1);
		} else if(num%5==2 || num%5==4) {
			System.out.println((num/5) + 2);
		}
	}
}
