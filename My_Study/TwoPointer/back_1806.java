package TwoPointer;

import java.io.*;
import java.util.*;

public class back_1806 {
	static int N,S,min=987654321;
	static int [] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		two();
		
	}
	private static void two() {
		int j=0, sum=0;
		for(int i=0; i<N; i++) {
			if(sum>=S) {
				min = Math.min(min, (j-i));
			}
			
			while(j<N && sum<S) {
				sum+=arr[j++];
//				if(sum>=S) {
//					min = Math.min(min, (j-i));
//				}
			}
			sum-=arr[i];
			
		}
		
		
		
	}
}
