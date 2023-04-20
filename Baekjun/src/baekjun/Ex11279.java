package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Ex11279 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			
			if(x!=0) { //x�� 0�� �ƴ϶�� �� �߰�
				pq.add(x);
			} else { //x�� 0�̶�� ���� ū�� ��� �� �� ���� �迭���� ����
				
				if(pq.size()==0) {
					System.out.println("0");
				} else {
					System.out.println(pq.poll());
				}
			}
		}
	}

}
