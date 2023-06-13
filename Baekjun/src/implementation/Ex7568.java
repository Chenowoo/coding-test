package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex7568 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int cnt = 0;
			for(int j=0; j<n; j++) {
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					cnt++;
				}
			}
			sb.append(cnt+1).append(" ");
		}
		System.out.println(sb);
	}

}
