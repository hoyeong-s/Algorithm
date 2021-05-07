package week6;

import java.io.*;
import java.util.*;

public class back_2470 {
	static int N;
	static long save=Long.MAX_VALUE;
	static long [] arr;
	static long [] result = new long[2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
			arr[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
		search();
		System.out.println(result[0] +" "+result[1]);
	}
	private static void search() {
		int start=0, end=N-1;
		
		while(start < end) {
			long sum = arr[start] + arr[end];
			if(Math.abs(sum)<save) {
				save = Math.abs(sum);
				result[0] = arr[start];
				result[1] = arr[end];
			}
			if(sum<0) start++;
			else end--;
		}
	}
}