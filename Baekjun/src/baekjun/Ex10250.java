package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10250 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] arr= new int[3];
		
		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			for(int j=0; j<arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			if(arr[2]<arr[0]) {
				System.out.println(arr[2]+ "01");
			} else if(arr[2]>=arr[0]) {
				if(arr[2]%arr[0]==0) {//arr[2]�� arr[0]�� ������
					if((arr[2]/arr[0])<10) { //ȣ���� 10���� ���� ��� 0Yȣ �پ����
						System.out.println(arr[0]+"0"+(arr[2]/arr[0]));
					} else {
						System.out.println(arr[0]+""+(arr[2]/arr[0]));
					}
				} else { //arr[2]�� arr[0]�� ����� �ƴ϶��
					if(arr[2]/arr[0]<9) {//ȣ���� 10���� ���� ���
						System.out.println((arr[2]%arr[0])+"0"+((arr[2]/arr[0])+1));
					} else {//ȣ���� 10���� Ŭ ���
						System.out.println((arr[2]%arr[0])+""+((arr[2]/arr[0])+1));
					}
				}
			}
		}
	}

}
