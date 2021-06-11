package BruteForce;
import java.io.*;
import java.util.*;

public class back_16637 {
	static int N,result=-999999999;
	static char[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N];
		String str = br.readLine();
		arr = str.toCharArray();
		
		if(!Character.isDigit(arr[0])) {
			dfs(1,-arr[0]);
		}
		else dfs(0,arr[0]-'0');
		System.out.println(result);
	}

	private static int cal(int a, char c, int b) {
		if(c=='+') return a+b;
		else if(c=='-') return a-b;
		else return a*b;
	}
	
	private static void dfs(int idx, int sum) {
		if(idx>=N-1) {
			result = Math.max(sum, result);
			return;
		}
		int ret = cal(sum,arr[idx+1],arr[idx+2]-'0');
		dfs(idx+2,ret);
		
		if(idx+4<N) {
			int ret1 = cal(arr[idx+2]-'0',arr[idx+3],arr[idx+4]-'0');
			ret = cal(sum,arr[idx+1],ret1);
			dfs(idx+4,ret);
		}
	}
}
