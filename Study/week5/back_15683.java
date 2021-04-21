package week5;

import java.io.*;
import java.util.*;

class Dot{
	int r,c;

	public Dot(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
}
public class back_15683 {
	static int N,M,cctv,result=987654321;
	static int [][] map;
	static int [][] case3 = {{0,3},{0,2},{1,2},{1,3}};
	static int [][] case4 = {{0,2,3},{1,2,3},{0,1,3},{0,1,2}};
	final static int [] dr = {-1,1,0,0};
	final static int [] dc = {0,0,-1,1};
	static ArrayList<Dot>list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=6 && map[i][j]!=0) {
					cctv++;
					list.add(new Dot(i,j));
				}
			}
		}
	
		move(0, map);
		System.out.println(result);
		
	}
	private static void move(int cnt, int [][] mapi) {
		if(cnt == cctv) {
			result = Math.min(cnt(mapi), result);
			return;
		}
		
		int r = list.get(cnt).r;
		int c = list.get(cnt).c;
		see(r,c,cnt,mapi);

	}
	
	private static int [][] copy(int [][] map) {
		int [][] c = new int [N][M];
		
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				c[i][j] = map[i][j];
		
		return c;
	}
	
	private static int cnt(int [][] map) {
		int count =0;
		
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				if(map[i][j]==0) count++;
			
		return count;
	}
	
	private static void see(int r, int c, int count, int [][] map) {
		switch(map[r][c]) {
		case 1 : {
			for(int dir=0; dir<4; dir++) {
				int cnt=1;
				int rr = r;
				int cc = c;
				int [][] mapc = copy(map);
				while(true) {
					int nr = rr + cnt * dr[dir];
					int nc = cc + cnt * dc[dir];
					if(nr<0 || nc<0 || nr>=N || nc>=M) break;
					if(mapc[nr][nc]==0) mapc[nr][nc] = -1;
					else if(mapc[nr][nc]==6) break;
					cnt++;
				}
				move(count+1, mapc);
			}
			break;
		}
		case 2:{
			for(int i=0; i<2; i++) {
				int j = 0;
				if (i == 1) j = 2;
				int[][] mapc = copy(map);
				for (int dir = j; dir < j + 2; dir++) {
					int cnt = 1;
					int rr = r;
					int cc = c;
					while (true) {
						int nr = rr + cnt * dr[dir];
						int nc = cc + cnt * dc[dir];
						if (nr < 0 || nc < 0 || nr >= N || nc >= M) break;
						if (mapc[nr][nc] == 0) mapc[nr][nc] = -1;
						else if (mapc[nr][nc] == 6)
							break;
						cnt++;
					}
				}
				move(count+1, mapc);
			}
			break;
		}
		case 3:{
			
			for(int i=0; i<4; i++) {
				int[][] mapc = copy(map);
				for (int dir = 0; dir < 2; dir++) {
					int cnt = 1;
					int rr = r;
					int cc = c;
					while (true) {
						int nr = rr + cnt * dr[case3[i][dir]];
						int nc = cc + cnt * dc[case3[i][dir]];
						if (nr < 0 || nc < 0 || nr >= N || nc >= M) break;
						if (mapc[nr][nc] == 0) mapc[nr][nc] = -1;
						else if (mapc[nr][nc] == 6)
							break;
						cnt++;
					}
				}
				move(count+1, mapc);
			}
			break;
		}
		case 4:{
			for(int i=0; i<4; i++) {
				int[][] mapc = copy(map);
				for (int dir = 0; dir < 3; dir++) {
					int cnt = 1;
					int rr = r;
					int cc = c;
					while (true) {
						int nr = rr + cnt * dr[case4[i][dir]];
						int nc = cc + cnt * dc[case4[i][dir]];
						if (nr < 0 || nc < 0 || nr >= N || nc >= M) break;
						if (mapc[nr][nc] == 0) mapc[nr][nc] = -1;
						else if (mapc[nr][nc] == 6)
							break;
						cnt++;
					}
				}
				move(count+1, mapc);
			}
			break;
		}
		case 5:{
			int[][] mapc = copy(map);
			for (int dir = 0; dir < 4; dir++) {
				int cnt = 1;
				int rr = r;
				int cc = c;
				while (true) {
					int nr = rr + cnt * dr[dir];
					int nc = cc + cnt * dc[dir];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M) break;
					if (mapc[nr][nc] == 0) mapc[nr][nc] = -1;
					else if (mapc[nr][nc] == 6)
						break;
					cnt++;
				}
			}
			move(count+1, mapc);
			break;
		}
		
		}
	}
}
