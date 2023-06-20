package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("");
		int min = Integer.MAX_VALUE;
		
		if(str.length == 1) {
			min = 1;
		} else {
			int cnt = 0;
			
			for(int i=1; i<=str.length/2; i++) {
				Stack<String> s = new Stack<>();
				cnt = 0;
				
				for(int j=0; j<str.length; j+=i) {
					
					String new_str = "";
					int idx = j;
					
					while(new_str.length()!=i) {
						if(idx == str.length) break;
						else {
							new_str += str[idx];
							idx++;
						}
					}
					
					
					
					if(s.isEmpty()) {//�ʱⰪ �ֱ�
						s.push(new_str);
						cnt++;
//						System.out.println("�ʱⰪ : " + new_str + ", cnt : " + cnt);
					} else {//�տ� ���� �ִٸ�
						
						if(s.peek().equals(new_str)) {
							cnt++;
//							System.out.println("���� �Ͱ� ���� : " + new_str + ", cnt : " + cnt);
						} else {//�ٸ��ٸ�
							if(cnt==1) {
								s.push(new_str);
//								System.out.println("���� �Ͱ� �ٸ��� cnt=1�� ���� : " + new_str);
							} else {
								String word = s.peek();
								s.pop();
								s.push(String.valueOf(cnt));
								s.push(word);
								s.push(new_str);
//								System.out.println("���� �Ͱ� �ٸ��� cnt!=1�� ���� : " + new_str + ", cnt : " + cnt);
								cnt = 1;
							}
						}				
					}
					
					if(j+i==str.length) {
						if(cnt!=1) {
							String last_word = s.peek();
							s.pop();
							s.push(String.valueOf(cnt));
							s.push(last_word);
						}
					}
//					for(String v : s) {
//						System.out.print(v);
//					}
//					System.out.println();
				}
				String str_len = "";
				for(String v : s) {
					str_len += v;
				}
				
				min = Math.min(min, str_len.length());
//				System.out.println("�ּ� ���� : " + min);
			}
			System.out.println(min);
		}

	}

}
