package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_11725 {
	static int N;
	static int [] arr;
	static boolean [] visited;
	static ArrayList<Integer> [] list; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		arr = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list[s].add(p);
			list[p].add(s);
		}
		node();
		for(int i=2; i<=N; i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}
	
	private static void node() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()) {
			int n = q.poll();
			if(visited[n]) continue;
			visited[n] = true;
			
			for(int i=0; i<list[n].size(); i++) {
				int next = list[n].get(i);
				if(!visited[next]) {
					arr[next] = n;
					q.add(next);
				}
			}
		}
		
	}
}
