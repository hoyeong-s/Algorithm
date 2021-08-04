package cs1;

import java.io.*;
import java.util.*;

public class back_2281 {
	static int N,M,result = 987654321;
	static int [] name;
	static int [][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		name = new int [N];
		dp = new int [N][M+1];
		for(int [] row : dp)
			Arrays.fill(row, -1);
		
		for(int i=0; i<N; i++) 
			name[i] = Integer.parseInt(br.readLine());
		
		System.out.println(note(1,name[0]));
	}
	// top-down 형식으로 끝에서부터 계산
	private static int note(int idx, int row) { // row : 현재까지 그 줄의 채워진 칸의 길이
		if(idx>=N) return 0;
		
		if(dp[idx][row]!=-1) return dp[idx][row];
		
		int cal = M - row;
		dp[idx][row] = note(idx+1,name[idx]) + (int)Math.pow(cal,2); // 다음줄에 넣음
		
		cal = row + 1 + name[idx];
		if(cal<=M) { // 해당 줄에 넣을 수 있는 경우
			dp[idx][row] = Math.min(dp[idx][row], note(idx+1, cal));
		}
					
		return dp[idx][row];
	}
}
