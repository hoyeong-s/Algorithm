package week4;

import java.util.*;
import java.io.*;

public class back_1325 {
	static int N,M,result,count;
	static int [] arr;
	static ArrayList<Integer> [] list;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++)
			list[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list[f].add(t);
		}
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(visited, false);
			dfs(i,visited);
		}
		
		for(int i=1; i<=N; i++) {
			if(arr[i]==result) sb.append(i+" ");
		}
		System.out.println(sb);
	}
	private static void dfs(int s, boolean [] visited) {
		visited[s] = true;
		
		for (int i = 0; i < list[s].size(); i++) {
			int next = list[s].get(i);
			if (visited[next])	continue;
			arr[next]++;
			result = Math.max(arr[next], result);
			dfs(next,visited);
		}
	}
}
