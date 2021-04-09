package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1707 {
	static int V,E;
	static int [] color;
	static ArrayList<Integer> [] list;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		outloop : for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			color = new int [V+1];
			
			list = new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}
			
			for(int i=1; i<=V; i++) {
				if(color[i]==0) {
					if(!bfs(i)) {
						sb.append("NO\n");
						continue outloop;
					}
				}
			}
			sb.append("YES\n");
		}
		System.out.println(sb);
	}
	private static boolean bfs(int c) {
		q.clear();
		q.add(c);
		color[c] = 1;
		while (!q.isEmpty()) {
			int n = q.poll();
			
			for (int i = 0; i < list[n].size(); i++) {
				int t = list[n].get(i);
				if (color[n] == color[t]) { // 부모 자식의 색이 같은 경우
					return false;
				}
				if(color[t]!=0) continue;
				if (color[n] == 1)  color[t] = -1;
				else  color[t] = 1;
				q.add(t);
			}
		}
		return true;
	}
}
