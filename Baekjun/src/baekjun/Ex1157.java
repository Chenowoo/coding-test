package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1157 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().toLowerCase();
		int[] indexArr = new int[26];
		
		for(int j=0; j<str.length(); j++) {
			char ch = str.charAt(j);
			
			indexArr[ch - 'a']++;
		}
		
		int max = indexArr[0];
		for(int i=0; i<indexArr.length-1; i++) { //�ִ� ��
			max = (max>indexArr[i+1]) ? max : indexArr[i+1];
		}
		
		int count = 0; //max���� ���������� �����ϱ� ���� ����
		char ch2 = 0; //�빮�� ����� ���� ����
		for(int k=0; k<indexArr.length; k++) {
			if(max == indexArr[k]) {
				count++; //max���� �������� ��� �����ϱ� ����
				ch2 = (char)(k + 'A');
			}
		}
		
		if(count>1) {
			System.out.println("?");
		} else
			System.out.println(ch2);
	}

}
