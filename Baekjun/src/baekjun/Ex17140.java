package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex17140 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[3][3];
		
		for(int i=0; i<3; i++) {//�ʱ�迭 ����
			for(int j=0; j<3; j++) {
				st = new StringTokenizer(br.readLine());
				
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int t = 0;
		int row = 3;//��
		int col = 3;//��
		int[][] new_Arr;
		
		while(true) {
			HashMap<Integer, Integer> map;
			//1. ��>=���� ����
			//2. ��<���� ���
			if(row >= col) { //��>=���� ���
				map = new HashMap<Integer, Integer>();
				
				//�ʱ� �迭�� col || row���� 2�� �Ǵ� �� �� ũ�� ����
				//���ο� �迭 ������ ���� ũ�� ���ϱ�
				for(int i=0; i<row; i++) {
					for(int j=0; j<col; j++) {
						map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
					}
				}
				
				col = map.size()*2;
				if(col > 100) col = 100;//100�� �Ѿ�� ��� 100���� ����
				new_Arr = new int[row][col];//�迭 �����
				
				for(int i=0; i<row; i++) {
					map = new HashMap<Integer, Integer>();
					
					for(int j=0; j<col; j++) {
						map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
					}
					
				}
			} else { //��<���� ���
				map = new HashMap<Integer, Integer>();
				
				//���ο� �迭 ������ ���� ũ�� ���ϱ�
				for(int i=0; i<row; i++) {
					for(int j=0; j<col; j++) {
						map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
					}
				}
				
				row = map.size()*2;
				if(row > 100) row = 100;//100�� �Ѿ�� ��� 100���� ����
				new_Arr = new int[row][col];//�迭 �����
			}
			
			
		}
		
		
	}

}
