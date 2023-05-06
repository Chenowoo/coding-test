package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 0:��, 1:��, 2:��, 3:��
 * ����� ��ġ�� ������ boolean[]
 * ���� ���̸� ������ boolean[]
 * ���� ���� ������ ������ HashMap
 * ���� ������ ��Ÿ�� d
 * �������� ��Ÿ�� cnt
 * ���� ��ȯ�� �� �Լ� direc
 * �ڱ� �ڽ� ���� �ε��� or ������ üũ�� check �Լ�
 */
public class Ex3190 {
	public static int x, y, n, dir;
	public static boolean[][] snake;
	public static boolean[][] apple;
	public static HashMap<Integer, String> map = new HashMap<Integer, String>();
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {1, 0, -1, 0};
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		snake = new boolean[n][n];
		apple = new boolean[n][n];
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int apple_x = Integer.parseInt(st.nextToken())-1;
			int apple_y = Integer.parseInt(st.nextToken())-1;
			
			apple[apple_x][apple_y] = true;
		}
		
		int l = Integer.parseInt(br.readLine());
		
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			
			map.put(count, d);
		}
		
		x = 0;
		y = 0;
		int tail_x;
		int tail_y;
		snake[x][y] = true;
		int cnt = 0;//�ʸ� �� ī��Ʈ
		dir = 100;
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		Pair cur;
		
		while(!check(dir%4)) {//check�� true�� �� ������
			x += dx[dir%4];
			y += dy[dir%4];
			
			if(apple[x][y]==true) {//�̵��� ĭ�� ����� �ִٸ� ����� �������� ������ �������� ����
				q.add(new Pair(x,y));
				snake[x][y] = true;
				apple[x][y] = false;
			} else {//�̵��� ĭ�� ����� ���ٸ� �����̸� �ٿ��� ������ ��ġ�� ĭ�� ���.
				q.add(new Pair(x,y));
				cur = q.poll();
				tail_x = cur.x;
				tail_y = cur.y;
				snake[tail_x][tail_y]=false;
				snake[x][y]=true;
			}
			cnt++;
			if(map.containsKey(cnt)) {
				changeDirection(map.get(cnt));
			}
			
			
		}
		System.out.println(cnt+1);
	}
	
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static boolean check(int direction) {
		int nx = x + dx[direction];
		int ny = y + dy[direction];
		
		if(nx<=-1 || nx>=n || ny<=-1 || ny>=n) {//����ĭ�� ���̶�� true ��
			return true;
		}
		if(snake[nx][ny]==true) {//����ĭ�� �ڱ� ���̶�� true ��
			return true;
		}
		return false;
	}
	
	public static void changeDirection(String direction) {
		if(direction.equals("D")) {
			dir--;
		} else if(direction.equals("L")) {
			dir++;
		}
	}

}
