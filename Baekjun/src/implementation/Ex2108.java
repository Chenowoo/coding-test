package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/*import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;*/

public class Ex2108 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		/*HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();*/
		int[] list = new int[8002];
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			list[arr[i]+4000]++;
		}
		
		Arrays.sort(arr);//��������
		
		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += arr[i];
			/*map.put(arr[i], map.getOrDefault(arr[i], 0)+1);*/
		}
		
		boolean check = false;
		
		int mode = 0;
		int mode_max = 0;//�ֺ�
		for(int i=0; i<8002; i++) {
			if(mode_max<list[i]) {
				mode_max = list[i];
				mode = i-4000;
				check = true;
			} else if(mode_max==list[i] && check==true) {
				mode = i-4000;
				check = false;
			}
		}

		//map�� value���� ������������ ����(value�� ���ٸ� ��������)
		/*List<Entry<Integer, Integer>> listArr = new ArrayList<Entry<Integer,Integer>>(map.entrySet());
		
		Collections.sort(listArr, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if(o1.getValue() == o2.getValue()) {//value���� ���ٸ� key�� ��������
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		int[][] more_arr = new int[listArr.size()][2];
		
		int idx = 0;
		for(Entry<Integer, Integer> entry : listArr) {
			more_arr[idx][0] = entry.getKey();
			more_arr[idx][1] = entry.getValue();
			System.out.println(more_arr[idx][0] + " " + more_arr[idx][1]);
			idx++;
		}*/
		
		if(n==1) {
			sb.append(sum).append("\n");//������
			sb.append(sum).append("\n");
			sb.append(sum).append("\n");
			sb.append(0).append("\n");
		} else {
			if((float)sum/n > -1 && (float)sum/n < 0) {
				sb.append(0).append("\n");
			} else {
				sb.append((int)Math.round((float)sum/n)).append("\n");//������
			}
			sb.append(arr[arr.length/2]).append("\n");//�߰���
			sb.append(mode).append("\n");
			sb.append(arr[arr.length-1]-arr[0]);
		}
		System.out.println(sb);
	}
}
