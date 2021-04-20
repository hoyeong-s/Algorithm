package twopointer;

import java.util.*;
import java.io.*;

public class back_2531 {
	static int N,D,K,C;
	static int [] arr,visited;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int [N+K-1];
		visited = new int[D+1];
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K-1; i++)
			arr[N+i] = arr[i];

		System.out.println(sushi());
				
	}
	private static int sushi() {
		int size=0,max=0;
		for(int i=0; i<N+K-1; i++) {
			int x = arr[i];
			if(visited[x]==0) size++;
			visited[x]++;

			if(i>=K) {
				int out = arr[i-K];
				visited[out]--;
				if(visited[out]==0) size--;
			}
			if(size>=max) {
				if(visited[C]==0) max = size+1;
				else max = size;
			}
		}
		return max;
	}
}
