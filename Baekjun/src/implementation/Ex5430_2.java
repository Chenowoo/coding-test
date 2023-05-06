package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ex5430_2 {
	
	public static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			
			list = new ArrayList<Integer>();
			String func = br.readLine();//�Լ��� ���� ���ڿ�
			int n = Integer.parseInt(br.readLine());
			boolean check =false;
			
			if(n!=0) {//n�� 0�� �ƴ� ���
				String str = br.readLine().replaceAll("[^0-9]", ".");//�迭�� ���� ���ڿ�
				String[] num = str.substring(1, str.length()-1).split("\\.");
				
				for(String s : num) {
					list.add(Integer.parseInt(s));
				}
				
				int cnt = 0;//R�� ���� ī��Ʈ
				for(int j=0; j<func.length(); j++) {
					if(func.charAt(j)=='R') {
						cnt++;
					} else if(func.charAt(j)=='D') {
						if(list.size()==0) {
							sb.append("error").append("\n");
							check = true;
							break;
						}
						if(cnt>0 && cnt%2!=0) {//cnt�� Ȧ����� R�� �ѹ��� ����
							Collections.reverse(list);
						}
						list.remove(0);
						cnt=0;
					}
				}
				if(cnt>0 && cnt%2!=0) {//cnt�� Ȧ����� R�� �ѹ��� ����
					Collections.reverse(list);
				}
				if(list.size()==0) {
					if(check) continue;//list.size()�� 0�� ���¿��� D�� ���� ���
					else {//list.size()�� 0�� ���¿��� �Լ��� ���� ���
						sb.append("[]").append("\n");
						continue;
					}
				} 
				sb.append("[");
				for(int j=0; j<list.size()-1; j++) {
					sb.append(list.get(j)).append(",");
				}
				sb.append(list.get(list.size()-1)).append("]").append("\n");
			} else {//n�� 0�ϰ�� 
				String str = br.readLine().replaceAll("[^0-9]", "");
				
				if(func.contains("D")) {
					sb.append("error").append("\n");
					continue;
				} else {
					sb.append("[]").append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
