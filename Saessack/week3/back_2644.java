package week3;

import java.io.*;
import java.util.*;

public class back_2644 {
	static int N,M,S,R;
	static ArrayList<Integer> [] list;
	static int [] visited;
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) 
			list[i] = new ArrayList<>();
		visited = new int[N+1];
		Arrays.fill(visited, -1);
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		find();
		System.out.println(visited[R]);
	}
	private static void find() {
		q.add(S);
		visited[S]=0;
		
		while(!q.isEmpty()) {
			int p = q.poll();
			
			if(p==R) break;
			
			for(int i=0; i<list[p].size(); i++) {
				int c = list[p].get(i);
				if(visited[c]==-1) {
					visited[c] = visited[p]+1;
					q.add(c);
				}
			}
		}
	}
}
