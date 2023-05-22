package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Lv1ex3 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] answers = {1,2,3,4,5};
		
		System.out.println(Arrays.toString(solution(answers)));
		
	}
	
	public static int[] solution(int[] answers) {
		int[] answer = {};
		
		int[] answer1 = {1,2,3,4,5};
		int[] answer2 = {2,1,2,3,2,4,2,5};
		int[] answer3 = {3,3,1,1,2,2,4,4,5,5};
		int[] idx = {0,0,0};
		int[] cnt = {0,0,0};
		
		for(int i=0; i<answers.length; i++,idx[0]++,idx[1]++,idx[2]++) {
			if(idx[0]==answer1.length) idx[0] = 0;
			if(idx[1]==answer2.length) idx[1] = 0;
			if(idx[2]==answer3.length) idx[2] = 0; 
			
			if(answer1[idx[0]]==answers[i]) cnt[0]++;//1�����ڰ� ���� ����
			if(answer2[idx[1]]==answers[i]) cnt[1]++;//2�����ڰ� ���� ����
			if(answer3[idx[2]]==answers[i]) cnt[2]++;//3�����ڰ� ���� ����
		}
		
		//����� ���� 7����
		//3���� �� ���ų�
		//1,2 1,3 2,3
		//1 2 3
		
		if(cnt[0]==cnt[1] && cnt[0]==cnt[2]) {//3���� �� ���� ���
			answer = new int[3];
			answer[0]=1;
			answer[1]=2;
			answer[2]=3;
		} else if(cnt[0]>cnt[2] && cnt[0]==cnt[1]) {
			answer = new int[2];
			answer[0] = 1;
			answer[1] = 2;
		} else if(cnt[0]>cnt[1] && cnt[0]==cnt[2]) {
			answer = new int[2];
			answer[0] = 1;
			answer[1] = 3;
		} else if(cnt[1]>cnt[0] && cnt[1]==cnt[2]) {
			answer = new int[2];
			answer[0] = 2;
			answer[1] = 3;
		} else if(Math.max(cnt[0], Math.max(cnt[1], cnt[2]))==cnt[0]) {
			answer = new int[1];
			answer[0] = 1;
		} else if(Math.max(cnt[0], Math.max(cnt[1], cnt[2]))==cnt[1]) {
			answer = new int[1];
			answer[0] = 2;
		} else if(Math.max(cnt[0], Math.max(cnt[1], cnt[2]))==cnt[2]) {
			answer = new int[1];
			answer[0] = 3;
		}
		
		return answer;
	}
}
