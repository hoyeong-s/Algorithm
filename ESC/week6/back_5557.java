package week6;

import java.io.*;
import java.util.*;

public class back_5557 {
	static int N,last,result;
	static int [] arr;
	static long [][] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int [N];
		check = new long [N-1][21];
		for(long [] row : check)
			Arrays.fill(row, -1);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		last = Integer.parseInt(st.nextToken());
		
		System.out.println(cal(1,arr[0]));
	}
	private static long cal(int idx, int sum) {
		if(idx==N-1) {
			if(sum==last) {
				return 1;
			}
			else return 0;
		}		
		int a = arr[idx];
		
		if(check[idx][sum]!=-1) return check[idx][sum];
		
		long result=0;
		if(sum+a<=20) result+=cal(idx+1, sum+a);
		if(sum-a>=0) result+=cal(idx+1, sum-a);
		
		check[idx][sum] = result;
		return result;
	}
}
