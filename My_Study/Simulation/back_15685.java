package Simulation;

import java.io.*;
import java.util.*;

public class back_15685 {
	static class Dot{
		int r,c;

		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static boolean [][] map = new boolean [101][101];
	static int [] dr = {0,-1,0,1};
	static int [] dc = {1,0,-1,0};
	static ArrayList<Dot> list = new ArrayList<>();
	static int result = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
			
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			dragon(c,r,d,g);
			list.clear();
		}
		
		find();
		System.out.println(result);
		
	}
	private static void dragon(int c, int r, int d, int g) {
	
		int nr = r + dr[d];
		int nc = c + dc[d];
		list.add(new Dot(r,c));
		list.add(new Dot(nr,nc));
		map[r][c] = true;
		map[nr][nc] = true;
		
		for(int i=0; i<g; i++) {
			make();
		}
	}
	
	private static void make() {
		Dot xd = list.get(list.size()-1);
		int xr = xd.r; // 끝점
		int xc = xd.c;
		int size = list.size();
		
		for(int i=size-2; i>=0; i--) {
			Dot d = list.get(i);
			int r = d.r;
			int c = d.c;
			
			int nr = xr-xc+c;
			int nc = xr+xc-r;
			map[nr][nc] = true;
			list.add(new Dot(nr,nc));
		}
	}
	
	private static void find() {
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) 
					result++;
			}
		}
	}
}
