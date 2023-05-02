package codingTest;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise {
	public static int n;
	public static int[] arr, new_arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{//배열이 주어졌을때 3가지 수를 뽑는 경우의 수를 모두 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[3];
		visited = new boolean[n];
		new_arr = new int[n];//3개를 뽑아서 넣을 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			new_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(new_arr);
		
		check(0);
		
		System.out.println(sb);
		
	}
	
	public static void check(int count) {
		if(count==3) {
			for(int v : arr) {
				sb.append(v).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[count] = new_arr[i];
				check(count + 1);
				visited[i] = false;
			}
		}
	}
	

}
