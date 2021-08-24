package cs1;

import java.io.*;
import java.util.*;

public class back_17281 {
	static int N,max;
	static int [] arr = new int [9];
	static int [][] score;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		score = new int [N][9];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++)
				score[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<9; i++)
			arr[i] = i;
		
		do {
			cal(change());
		}while(np());
		
		System.out.println(max);
	}
	
	private static boolean np() { // 순열
		int i = 8;
		while(i>0 && arr[i-1]>=arr[i]) --i;
		if(i==1) return false;
		
		int j=8;
		while(arr[i-1]>=arr[j]) --j;
		
		swap(i-1,j);
		
		int k = 8;
		while(i<k)
			swap(i++,k--);
		
		return true;
	}
	
	private static void swap(int i, int j) {
		int cur = arr[i];
		arr[i] = arr[j];
		arr[j] = cur;
	}
	
	private static int [] change() { // 1번선수 항상 4번타자
		int [] temp = arr.clone();
		
		int t = temp[0];
		temp[0] = temp[1];
		temp[1] = temp[2];
		temp[2] = temp[3];
		temp[3] = t;
				
		return temp;
	}
	
	private static void cal(int [] arr) {
		int cnt = 0;
		int out = 0;
		int hitter = 0; // 현재 타자 
		boolean [] base = new boolean [3];
		
		for (int i = 0; i < N; i++) {
			out = 0;
			Arrays.fill(base, false);
			while (out <= 2) { // 회당 아웃카운트 계산
				int cur = score[i][arr[hitter]];
				if(cur==0) out ++;
				else {
					if(cur==1) { // 1루타 일 때
						for(int j=2; j>=0; j--) {
							if(base[j]) {
								if(j+1>=3) cnt++;
								else base[j+1] = true;
								base[j] = false;
							}
						}
						base[0] = true;
					}
					else if(cur==2) { // 2루타 일 때
						for(int j=2; j>=0; j--) {
							if(base[j]) {
								if(j+2>=3) cnt++;
								else base[j+2] = true;
								base[j] = false;
							}
						}
						base[1] = true;
					}
					else if(cur==3) { // 3루타 일 때
						for(int j=2; j>=0; j--) {
							if(base[j]) {
								cnt++;
								base[j] = false;
							}
						}
						base[2] = true;
					}
					else { // 홈런
						for(int j=2; j>=0; j--) {
							if(base[j]) {
								cnt++;
								base[j] = false;
							}
						}
						cnt++;
					}
				}
				hitter++;
				if(hitter>=9) hitter = 0;
			}
		}
		max = Math.max(max, cnt);
	}
	
	private static int move(int num) {
		int cnt = 0;
		
		return cnt;
	}
}

