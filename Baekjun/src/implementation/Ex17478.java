package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex17478 {
	public static int n;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		sb.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.").append("\n");
		recursion(0);
		
		System.out.println(sb);
	}
	
	public static void recursion(int a) {
		
		if(a<n) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<a; j++) {
					spec();
				}
				shout(i);
			}
		} else if(a==n) {
			for(int i=0; i<6; i++) {
				if(i==1 || i==2 || i==3) continue;
				for(int j=0; j<a; j++) {
					spec();
				}
				shout(i);
			}
			return;
		}
		
		recursion(a+1);
		
		for(int i=0; i<a; i++) {
			spec();
		}
		shout(5);
		
		
	}

	public static void shout(int n) {
		if(n==0) {
			sb.append("\"����Լ��� ������?\"").append("\n");
		} else if(n==1) {
			sb.append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.").append("\n");
		} else if(n==2) {
			sb.append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.").append("\n");
		} else if(n==3){
			sb.append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"").append("\n");
		} else if(n==4){
			sb.append("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"").append("\n");
		} else {
			sb.append("��� �亯�Ͽ���.").append("\n");
		}
	}
	public static void spec() {
		sb.append("____");
	}

}
