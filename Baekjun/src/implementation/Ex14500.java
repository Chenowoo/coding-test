package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14500 {
	public static int n, m, sum;
	public static int[][] arr, new_arr;
	public static int max = Integer.MIN_VALUE;
	public static boolean[][] arr_tetro, new_check, new_arr_tetro;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];//�⺻�迭
		new_arr = new int[n+6][m+6];//Ȯ���� �迭
		
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				new_arr[i+3][j+3] = arr[i][j]; 
			}
		}
		
		for(int k=0; k<n+3; k++) {
			for(int l=0; l<m+3; l++) {
				for(int i=1; i<6; i++) {
					tetromino(i);
					
					//ȸ�� �� ��ĭ�� �̵��ϸ鼭 �� ���ϰ� max�� ���ϱ�
						for(int r=0; r<4; r++) {
							
							turn(arr_tetro, new_arr_tetro, r);
							new_check = new boolean[n+6][m+6];//Ȯ��� boolean�迭
							
							for(int o=k; o<k+new_arr_tetro.length; o++) {
								for(int p=l; p<l+new_arr_tetro[0].length; p++) {
									new_check[o][p] = new_arr_tetro[o-k][p-l];
								}
							}
							
							//��ġ�� �κ��� arr_tetro�� ture��� �� �ε����� ���� sum�� ���ϱ�
							max = Math.max(max, check(new_check));
						}
						
				}
			}
		}
		System.out.println(max);
		
	}
	public static boolean[][] turn(boolean[][] arr, boolean[][] arr2, int r) {//�ð�������� 90�� ȸ��
		new_arr_tetro = new boolean[4][4];
		
		if(r==0) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					arr2[i][j] = arr[i][j];
				}
			}
		} else if(r==1) { //90��
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					arr2[i][j] = arr[3-j][i];
				}
			}
		} else if(r==2) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					arr2[i][j] = arr[3-i][3-j];
				}
			}
		} else if(r==3) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					arr2[i][j] = arr[j][3-i];
				}
			}
		}
		
		return arr2;
	}
	
	
	public static void tetromino(int n) {//4x4�迭 ���� �� 1~5���� ���ڰ� ������ �� �迭 �ʱ�ȭ �� �� ����
		//n���� ���� �� ���� arr�迭 �ʱ�ȭ
		arr_tetro = new boolean[4][4]; //tetro�� ������ �� �迭
		
		if(n==1) {//������
			for(int i=0; i<4; i++) {
				arr_tetro[0][i] = true;
			}
		} else if(n==2) {//���簢��
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					arr_tetro[i][j] = true;
				}
			}
		} else if(n==3) {//����
			for(int i=0; i<3; i++) {
				arr_tetro[0][i] = true;
			}
			arr_tetro[1][0] = true;
		} else if(n==4) {//�������
			arr_tetro[0][0] = true;
			arr_tetro[1][0] = true;
			arr_tetro[1][1] = true;
			arr_tetro[2][1] = true;
		} else if(n==5) {//�հ��� ���
			for(int i=0; i<3; i++) {
				arr_tetro[0][i] = true;
				arr_tetro[1][1] = true;
			}
		}
	}
	
	public static int check(boolean[][] arr) {//x,y�� new_arr�� ũ��
		int sum = 0;
		
		for(int i=0; i<n+6; i++) {
			for(int j=0; j<m+6; j++) {
				if(arr[i][j]) {//(i,j)�� true��� sum�� ���ϱ�
					sum+=new_arr[i][j];
				}
			}
		}
		return sum;
	}
}
