package LIS;

import java.io.*;
import java.util.*;

public class back_14003 {
	static int N,cnt;
	static int [] arr,list,dp,result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		dp = new int [N];
		list = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		cnt = LIS();
		sb.append(cnt+1+"\n");
		result = LIS2();
		for(int x : result)
			sb.append(x+" ");
		System.out.println(sb);
		
	}
	private static int LIS() {
		int cnt=0;
		list[0] = arr[0];
		for(int i=1; i<N; i++) {
			int cur = arr[i];
			if(cur>list[cnt]) {
				list[++cnt] = cur;
				dp[i] = cnt;
			}
			else {
				int idx = Arrays.binarySearch(list, 0, cnt,cur);
				if(idx<0) idx=-idx-1;
				list[idx] = cur;
				dp[i] = idx;
			}
		}
		return cnt;
	}

	private static int [] LIS2() { // 뒤에 나온 값이 가장 최근에 바뀐 값이므로 뒤에서 부터 탐색
		int [] result = new int[cnt+1];
		for(int i=N-1; i>=0; i--) {
			if(dp[i]==cnt) {
				result[cnt]=arr[i];
				cnt--;
			}
			if(cnt<0) break;
		}
		return result;
	}
}
