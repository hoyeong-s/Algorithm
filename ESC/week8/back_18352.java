package week8;

import java.io.*;
import java.util.*;

public class back_18352 {
	static int N,M,K,X;
	static int [] dis;
	static ArrayList<Integer> [] list;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dis = new int [N+1];
		Arrays.fill(dis, 987654321);
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			list[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list[f].add(t);
		}
		
		pq.add(X);
		dis[X] = 0;
		dijk();
	}
	private static void dijk() {
		while(!pq.isEmpty()) {
			int node = pq.poll();
			
			for(int i=0; i<list[node].size(); i++) {
				int next = list[node].get(i);
			}
		}
	}
}
