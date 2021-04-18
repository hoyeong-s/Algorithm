package week4;

import java.util.*;
import java.io.*;

class Dot2{
	int r,c;

	public Dot2(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}
public class back_14502 {
	static int N,M,idx,result=0;
	static int [][] map, map_c;
	static int [] combi;
	static Queue<Dot2> q = new LinkedList<>();
	static ArrayList<Dot2> list = new ArrayList<>();
	final static int [] dr = {0,0,-1,1};
	final static int [] dc = {-1,1,0,0};
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		map_c = new int[N][M];
		combi = new int [N*M];
		
		idx=0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					combi[idx++] = i*M + j;
				}
				else if(map[i][j]==2)
					list.add(new Dot2(i,j));
			}
		}
		
		combination(0,new int[3], 0);
		System.out.println(result);
	}
	private static void combination(int select, int[] save, int start) {
		if(select == 3) {
			bfs(save);
			return;
		}
		
		for(int i=start; i<idx; i++) {
			save[select] = combi[i];
			combination(select+1, save, i+1);
		}
	}
	
	private static void bfs(int [] save) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map_c[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<3; i++) {
			int r = save[i] / M;
			int c = save[i] % M;
			map_c[r][c] = 1;
		}
		
		for(int i=0; i<list.size(); i++) {
			q.add(list.get(i));
		}
		
		int cnt=0;
		while(!q.isEmpty()) {
			Dot2 d = q.poll();
			int r = d.r;
			int c = d.c;
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				
				if(map_c[nr][nc]==0) {
					cnt++;
					map_c[nr][nc] = 2;
					q.add(new Dot2(nr,nc));
				}
			}
		}
		int sum = idx - cnt - 3;
		result = Math.max(result, sum);
	}
}
