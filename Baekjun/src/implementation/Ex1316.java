package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1316 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			
			String str = br.readLine();
			boolean[] check = new boolean[27];
			boolean visited = false;
			
			if(str.length()<=2) {
				answer++;
				continue;
			}
			
			for(int j=0; j<str.length(); j++) {
				if(!check[str.charAt(j)-'a']) {//ó�� ������ �ܾ���
					
					check[str.charAt(j)-'a'] = true;
					
				} else {//ó�� ���� �ܾ �ƴ϶��
					
					if(str.charAt(j) == str.charAt(j-1)) {
						
						continue;
						
					} else {
						
						visited = true;
						break;
						
					}
					
				}
			}
			if(!visited) answer++;
		}
		System.out.println(answer);
	}

}
