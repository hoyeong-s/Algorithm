package week6;

import java.io.*;
import java.util.*;

public class back_2470 {
	static int N;
	static long save=Long.MAX_VALUE;;
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
		binary();
		System.out.println(result[0] +" "+result[1]);
		
	}
	private static void binary() {
		for(int i=0; i<N-1; i++) {
			search(i+1,N-1,arr[i]);
		}
	}
	private static void search(int i, int j, long key) {
		int mid=0;
		int sss=0;
		long ss=Long.MAX_VALUE;
		while(i<=j) {
			mid = (i+j)/2;
			long cur = arr[mid];
			long sum = key+cur;
			
			if(Math.abs(ss) < Math.abs(sum)) break;
			
			if(sum<0) {
				i = mid+1;
			}
			else if(sum>0) {
				j = mid-1;
			}
			else {
				System.out.println(key+" "+arr[mid]);
				System.exit(0);
			}
			ss = key+cur;
			sss=mid;
		}
		if(save>Math.abs(ss)) {
			save = Math.abs(ss);
			result[0] = key;
			result[1] = arr[sss];
		}
		
	}
}
