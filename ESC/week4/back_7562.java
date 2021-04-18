package week4;

import java.util.*;
import java.io.*;

class b_7562{
	int r,c;

	public b_7562(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
}

public class back_7562 {
	static int N,cr,cc,ddr,ddc,result,INF=987654321;
	static int [][] map,visited;
	final static int [] dr = {-2,-1,1,2,2,1,-1,-2};
	final static int [] dc = {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			visited = new int [N][N];
			for(int [] row:visited)
				Arrays.fill(row, INF);
			
			st = new StringTokenizer(br.readLine());
			cr = Integer.parseInt(st.nextToken());
			cc = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			ddr = Integer.parseInt(st.nextToken());
			ddc = Integer.parseInt(st.nextToken());
			
			find(cr,cc);
			sb.append(visited[ddr][ddc]+"\n");
		}
		System.out.println(sb);
	}
	private static void find(int cr, int cc) {
		Queue<b_7562> q = new LinkedList<>();
		visited[cr][cc] = 0;
		q.add(new b_7562(cr, cc));
		
		while (!q.isEmpty()) {
			b_7562 b = q.poll();
			int r = b.r;
			int c = b.c;
					
			if (r == ddr && c == ddc) 
				continue;
			
			for (int dir = 0; dir < 8; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)  continue;
				if (visited[nr][nc] > visited[r][c]+1) {
					visited[nr][nc] = visited[r][c]+1;
					q.add(new b_7562(nr, nc));
				}

			}
		}
	}
}
