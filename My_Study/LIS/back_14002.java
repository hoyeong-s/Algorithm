package LIS;

import java.io.*;
import java.util.*;

public class back_14002 {
	static int N,idx;
	static int [] arr,dp,back;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		dp = new int [N];
		back = new int [N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = LIS();
		System.out.println(cnt);
		
		int [] result = new int[cnt];
		
		for(int i=cnt-1; i>=0; i--) {
			result[i] = arr[idx];
			idx = back[idx];
		}
		for(int x : result)
			sb.append(x+" ");
		System.out.println(sb);
	}
	private static int LIS() {
		int max=0;
		for(int i=0; i<N; i++) {
			dp[i]=1;
			back[i]=i;
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i] && dp[i]<dp[j]+1) {
					dp[i] = dp[j]+1;
					back[i] = j;
				}
			}
			if(max<dp[i]) {
				max = dp[i];
				idx=i;
			}
		}
		return max;
	}
}
