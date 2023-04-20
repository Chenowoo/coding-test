package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex10809 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		ArrayList<Character> arr = new ArrayList<Character>();
		char[] alpArr = new char[26];//���ĺ� ���� �迭
		int[] indexArr = new int[26];//�ε��� ���� �迭
		
		for(int i=0; i<alpArr.length; i++) {//�ƽ�Ű�ڵ� 97~122�� �ҹ��� a~z
			alpArr[i] = (char)(i+97);
			indexArr[i] = -1;
		}
		
		for(int i=0; i<str.length(); i++) { //�� ���ĺ� �迭 ����
			arr.add(str.charAt(i));
		}
		
		//arr.get(i)�� ���ĺ� a~z���� ��ġ�ϴ°� �ִٸ� i�� ����
		//��ø�ݺ���
		for(int j=0; j<arr.size(); j++) {
			for(int k=0; k<26; k++) {
				if(arr.get(j)==alpArr[k]) {
					if(indexArr[k]!=-1) break;
					else indexArr[k] = j;
				}
			}
		}
		
		for(int s : indexArr) {
			System.out.print(s + " ");
		}
	}
}
