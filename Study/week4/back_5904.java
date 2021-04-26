package week4;

import java.io.*;
import java.util.*;

public class back_5904 {
	static int N;
	static int [] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int [1000];
		dp[0] = 3;
		moo(3,0);
	}

	private static void moo(int s, int cnt) { // 어느 그룹인지 판단
		if(N < s) {
			if(dp[cnt-1] >= N-dp[cnt-1]) {
				N = N-dp[cnt-1];
				find(N,cnt-1);
			}
			else if(N > s-dp[cnt-1]) { // dp[cnt-1]에 속해있는지 판단
				N = N-dp[cnt-1]-(3+cnt);
				find(N,cnt-1);
			}
			else { // 새로 만든 문자열에 속해있는지 판단
				if(N == dp[cnt-1]+1) System.out.println("m");
				else System.out.println("o");
			}
		}
		else {
			dp[cnt+1] = 2*s+3+cnt+1;
			moo(2*s+3+cnt+1,cnt+1);
		}
	}
	
	private static void find(int s,int cnt) {
		if(cnt==0) {
			if(s==1) System.out.println("m");
			else System.out.println("o");
			return;
		}
		
		if(N <= dp[cnt-1]) {
			find(N,cnt-1);
		}
			
		else if(N > s-dp[cnt-1]) { // dp[cnt-1]에 속해있는지 판단
			N = N-dp[cnt-1]-(3+cnt);
			find(N,cnt-1);
		}
		else { // 새로 만든 문자열에 속해있는지 판단
			if(N == dp[cnt-1]+1) System.out.println("m");
			else System.out.println("o");
		}
	}
}

