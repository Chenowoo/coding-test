package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex20 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Character> arr = new ArrayList<Character>();
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				arr.add(str.charAt(j));
			}
			
			int count = 0;
			int[] list = new int[arr.size()];
			
			if(arr.get(0)=='O') list[0]=1;
			else list[0]=0;
			
			for(int j=1; j<arr.size(); j++) {
				if(arr.get(j-1)=='O') { //�� �ε��� ���� 'O'�� ���
					if(arr.get(j)=='O') { //�ش� �ε��� ���� 'O'�� ���
						list[j]=list[j-1]+1;
					} else { //�ش� �ε��� ���� 'X'�� ���
						list[j]=0;
					}
				} else { //�� �ε��� ���� 'X'�� ���
					if(arr.get(j)=='O') { //�ش� �ε��� ���� 'O'�� ���
						list[j]=1;
					} else { //�ش� �ε��� ���� 'X'�� ���
						list[j]=0;
					}
				}
			}
			for(int k=0; k<list.length; k++) {
				count+=list[k];
			}
			
			System.out.println(count);
			arr.clear();
		}
	}
}
