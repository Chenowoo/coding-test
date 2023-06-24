package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
 * 5
1 0 0 1
1 1 1 1
2 1 0 1
2 2 1 1
5 0 0 1
5 1 0 1
4 2 1 1
3 2 1 1
 */
public class Q12 {
	public static int[][] answer;
	public static boolean[][] pillar, bar;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		int[][] build_frame = new int[10][4];
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			build_frame[i][0] = Integer.parseInt(st.nextToken());
			build_frame[i][1] = Integer.parseInt(st.nextToken());
			build_frame[i][2] = Integer.parseInt(st.nextToken());
			build_frame[i][3] = Integer.parseInt(st.nextToken());
		}
		
		solution(n, build_frame);
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i][0] + ", " + answer[i][1] + ", " + answer[i][2]);
		}
	}
	
	public static int[][] solution(int n ,int[][] build_frame) {
		
		pillar = new boolean[n+1][n+1];
		bar = new boolean[n+1][n+1];
		
		int count = 0;
		for(int i=0; i<build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2];//0 : ���, 1 : ��
			int b = build_frame[i][3];
			
			
			if(a==0) {//����� ��
				if(b==1) {//��ġ
					if(checkPillar(x, y)) {
						pillar[x][y] = true;
						count++;
					}
				} else {//����
					pillar[x][y] = false;
					if(!canDel(n)) pillar[x][y] = true;
					else count--;
				}
			} else {//���� ��
				if(b==1) {//��ġ
					if(checkBar(x,y)) {
						bar[x][y] = true;
						count++;
					}
				} else {//����
					bar[x][y] = false;
					if(!canDel(n)) bar[x][y] = true;
					else count--;
				}
			}
		}
		
		int[][] answer = new int[count][3];
		int idx = 0;
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=n; j++) {
				if(pillar[i][j]) {
					answer[idx][0] = i;
					answer[idx][1] = j;
					answer[idx++][2] = 0;
				}
				if(bar[i][j]) {
					answer[idx][0] = i;
					answer[idx][1] = j;
					answer[idx++][2] = 1;
				}
			}
		}
		
		Arrays.sort(answer, new Comparator<int[]> () {
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0] && o1[1]==o2[1]) {
					return o1[2] - o2[2];
				}
				if(o1[0]==o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		return answer;
	}
	public static boolean canDel(int n) {
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=n; j++) {
				if(pillar[i][j] && !checkPillar(i, j)) return false;
				else if(bar[i][j] && !checkBar(i, j)) return false;
			}
		}
		return true;
	}
	
	public static boolean checkPillar(int x, int y) {
		if(y==0) return true;
		else if(y>0 && pillar[x][y-1]) return true;//�Ʒ��� ����ִ� ���
		else if(x>0 && bar[x-1][y] || bar[x][y]) return true;//���� ���ΰ��
		return false;
	}
	
	public static boolean checkBar(int x, int y) {
		if(y>0 && pillar[x][y-1] || pillar[x+1][y-1]) return true;//���ʳ��� ����� ���
		else if(x>0 && bar[x-1][y] && bar[x+1][y]) return true;//���� ��� ���� ���
		return false;
	}
}
