package cs1;

import java.io.*;
import java.util.*;

public class back_2281 {
	static int N,M,result = 987654321;
	static int [] name, save;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		name = new int [N];
		save = new int [N];
		Arrays.fill(save, 987654321);
		
		for(int i=0; i<N; i++) 
			name[i] = Integer.parseInt(br.readLine());
		
		note(1,0,name[0]);
		System.out.println(result);
	}
	private static void note(int idx, int sum, int low) {
		if(idx>=N) {
			result = Math.min(result, sum);
			return;
		}
		
		int cal = low+1+name[idx]; // 현재 줄에서 지금까지 idx
		if(cal<=M) { // 그 줄에 넣는 경우
			note(idx+1,sum,cal);
		}
		sum += Math.pow(M-low,2);
		note(idx+1,sum,name[idx]);
	}
}
