package cs1;

import java.io.*;
import java.util.*;

public class back_17827 {
	static int N,M,V;
	static int [] snail;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		snail = new int [N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			snail[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(find(num)+"\n");
		}
		System.out.println(sb);
	}
	private static int find(int num) {
		if(num<N) return snail[num];
		if(V==N) return snail[N-1];
		
		int k = (num-N) % (N-V+1) + V-1;
		return snail[k];	
	}
	
}
