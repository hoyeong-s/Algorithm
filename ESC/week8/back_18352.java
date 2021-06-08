package week8;

import java.io.*;
import java.util.*;

class b_18352 implements Comparable<b_18352>{
	int node, wei;

	public b_18352(int node, int wei) {
		super();
		this.node = node;
		this.wei = wei;
	}

	@Override
	public int compareTo(b_18352 o) {
		// TODO Auto-generated method stub
		return this.node-o.node;
	}
	
}
public class back_18352 {
	static int N, M, K, X;
	static int[] dis;
	static ArrayList<Integer>[] list;
	static PriorityQueue<b_18352> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		dis = new int[N + 1];
		Arrays.fill(dis, 987654321);

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			list[f].add(t);
		}
		
		pq.add(new b_18352(X, 0));
		dis[X] = 0;
		dijk();
		for(int i=1; i<=N; i++) {
			if(dis[i]==K) sb.append(i+"\n");
		}
		if(sb.length()==0) sb.append(-1);
		System.out.println(sb);
	}

	private static void dijk() {
		
		while (!pq.isEmpty()) {
			b_18352 b = pq.poll();
			int node = b.node;
			int wei = b.wei;
			
			for (int i = 0; i < list[node].size(); i++) {
				int next = list[node].get(i);
				if(dis[next]>wei+1) {
					dis[next] = wei+1;
					pq.add(new b_18352(next,wei+1));
				}
			}
		}
	}
}
