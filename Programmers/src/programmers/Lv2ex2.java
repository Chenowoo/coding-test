package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Lv2ex2 {
	public static int size;
	public static int maps_size;
	public static String[][] arr;
	public static int sum;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
		
		System.out.println(Arrays.toString(solution(maps)));
	}
	
	public static int[] solution(String[] maps) {
		int[] answer = {};
		
		maps_size = maps.length;
		size = maps[0].length();//maps�ϳ��� ũ��
		arr = new String[maps.length][size];
		/*
		 * maps ��ü�� ���� int������ ��ȯ�ϸ� x
		 * 'X'�� int�� ��ȯ x
		 * X�� �ƴ϶������ ����
		 */
		
		for(int i=0; i<maps_size; i++) {
			char[] maps_char = maps[i].toCharArray();
			for(int j=0; j<size; j++) {
				arr[i][j] = String.valueOf(maps_char[j]);
			}
		}
		
		sum = 0;
		int cnt = 0; //-1��½� �ʿ��� cnt��
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<maps_size; i++) {
			for(int j=0; j<size; j++) {
				if(check(i,j)) {
					cnt++;
					list.add(sum);
					sum=0;
				}
			}
		}
		Collections.sort(list);

		if(cnt==0) {
			list.add(-1);
			answer = new int[list.size()];
			answer[0] = list.get(0);
		} else {
			answer = new int[list.size()];
			for(int i=0; i<list.size(); i++) {
				answer[i] = list.get(i);
			}
		}
		
		return answer;
	}
	
	public static boolean check(int x, int y) {
		if(x<=-1 || x>=maps_size || y<=-1 || y>=size) {
			return false;
		}
		
		if(!arr[x][y].equals("X")) {//�湮���� ���� ���, �� X�� �ƴ� ���ڶ��
			sum += Integer.parseInt(arr[x][y]);//�ش簪�� sum
			arr[x][y] = "X";//�湮�ߴٴ� ǥ�� X
			
			check(x-1, y);
			check(x, y-1);
			check(x+1, y);
			check(x, y+1);
			
			return true;
		}	
		
		return false;
	}
}
