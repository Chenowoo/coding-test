package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2750 {
	
	public static void insertion_sort(int[] a, int size) {
		for(int i=1; i<size; i++) {
			int target = a[i];
			
			int j = i-1;
			
			while(j>=0 && target<a[j]) {
				a[j+1] = a[j];
				j--;
			}
			
			a[j+1] = target;
		}
	}
	/*public static void selection_sort(int[] a, int size) {
		for(int i=0; i<size-1; i++) { //������ 2��°
			int min_index = i;
			
			for(int j=i+1; j<size; j++) { //������
				if(a[j] < a[min_index]) { //�ּڰ��� ������ �ִ� �ε���
					min_index=j;
				}
			}
			swap(a, min_index, i); //i��° ���� �ּڰ��� ��ȯ
		}
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}*/
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		insertion_sort(arr, arr.length);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		/*selection_sort(arr, arr.length);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}*/
	}

}
