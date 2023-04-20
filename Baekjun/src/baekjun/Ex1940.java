package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1940 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =Integer.parseInt(br.readLine());
		int m =Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);//��������
		
		int l = 0;
		int r = arr.length-1;
		int cnt = 0;
		
		while(r>l) {
			if(arr[l] + arr[r] < m) {//�� ������ ���� m���� �۴ٸ� l����
				l++;
			} else if(arr[l] + arr[r] > m) {//�� ������ ���� m���� ũ�ٸ� r����
				r--;
			} else {//�� ������ ���� m�� ���
				cnt++;
				l++;
			}
		}
		System.out.println(cnt);
	}

}
