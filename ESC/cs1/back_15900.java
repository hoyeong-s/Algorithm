package cs1;

import java.io.*;
import java.util.*;

public class back_15900 {
	static int N;
	static int [] visited;
	static ArrayList<Integer> [] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new int[N+1];
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		if(find()%2==1) System.out.println("Yes");
		else System.out.println("No");
		
	}
	
	private static int find() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		
		int sum=0;
		
		while(!q.isEmpty()) {
			int s = q.poll();
			
			int cnt=0;
			for(int i=0; i<list[s].size(); i++) {
				int next = list[s].get(i);
				if(visited[next]==0 && next!=1) {
					cnt++;
					if (s == 1) {
						visited[next] = 1;
					}
					else {
						visited[next] = visited[s]+1;
					}
					q.add(next);
				}
			}
			if(cnt==0) sum += visited[s];
		}
		return sum;
	}
}
