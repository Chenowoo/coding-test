package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ex2108 {

	public static void main(String[] args) throws IOException{
		//������ : ��ü �� / N���� (float)
		//�߾Ӱ� : �ø����� ���� �� �߾� �� (N/2��°)
		//�ֺ� : counting ���� �� �� �� ���� ���� ��
		//���� : �ִ� - �ּڰ�, N=1�� ��� 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();//������������ ������ �迭	
		boolean[] arr1 = new boolean[8001]; //int[4000]�� 0, �������� ���Ŀ� ����� �迭
		int[] arr2 = new int[8001];//�ֺ��� ���� �迭
		int[] arr3 = new int[8001];
		
		//1 2 3 4 5 6 7 8 9 10  arr1
		//0 1 1 2 2 2 2 2 2 2   arr2
		
		//arr[1000] = 2, arr[1002] = 3, arr[1003] = 3
		
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine())+4000;
			arr1[n] = true;
			arr2[n]++;
		}
		
		for(int i=0; i<8001; i++) {
			if(arr1[i]) {
				list.add(i-4000);
			}
		}
		
		for(int i=0; i<list.size(); i++) { //������ ���ϱ�
			sum += list.get(i);
		}
		double cnt = sum/N;
		String avg = String.format("%.0f", cnt);
		sb.append(avg).append('\n');//������
		sb.append(list.get(list.size()/2)).append('\n');//�߾Ӱ�
		
		//�ֺ��� arr2���� �ִ� ã�� �� �� �ε��� ��
		
		for(int i=1; i<8001; i++) {
			
		}

		int	size = list.get(list.size()-1) - list.get(0);
		sb.append(size).append('\n');//����
		
		System.out.println(sb);
		
	}

}
