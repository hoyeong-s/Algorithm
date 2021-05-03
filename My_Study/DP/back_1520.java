package DP;

import java.io.*;
import java.util.*;

public class back_1520 {
	static int N,M,result;
	static int [][] map,visited;
	final static int[] dr= {-1,1,0,0};
	final static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visited = new int[M][N];
		
		for(int [] row:visited)
			Arrays.fill(row, -1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(move(0, 0));
	}
	
	private static int move(int r, int c) {
		if (r == M - 1 && c == N - 1) {
			return 1;
		}
		if(visited[r][c] != -1) return visited[r][c];
		
		else {
			visited[r][c]=0;
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr < 0 || nc < 0 || nr >= M || nc >= N)
					continue;

				if (map[nr][nc] < map[r][c]) {
					visited[r][c] += move(nr, nc);
				}
			}
		}
		return visited[r][c];
	}
}


