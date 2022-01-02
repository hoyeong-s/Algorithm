package KAKAO_BLIND_RECRUITMENT_2021;

import java.io.*;
import java.util.*;

public class 카드_짝_맞추기 {
	static int cnt, min=987654321;
	final static int [] dr = {0,0,-1,1};
	final static int [] dc = {-1,1,0,0};
	static int [][] b;
		
	static class Dot{
		int r,c;

		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static HashMap<Integer, ArrayList<Dot>> map = new HashMap<>();
	
	public static void main(String[] args) {
		int [][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
		solution(board,1,0);
	}
	public static int solution(int[][] board, int r, int c) {
        int answer = 0;
        b = board;
        
        for(int i=0; i<4; i++) {
        	for(int j=0; j<4; j++) {
        		if(board[i][j]!=0) {
        			cnt++;
        			ArrayList<Dot> list;
        			if(map.containsKey(board[i][j])) list = map.get(board[i][j]);
        			else list = new ArrayList<>();
        			list.add(new Dot(i,j));
        			map.put(board[i][j], list);
        		}
        	}
        }
        cnt /= 2;
       boolean [] check = new boolean[cnt+1];
        
        if(board[r][c]==0) find(check,0,board,r,c,0,0);
        else {
        	ArrayList<Dot> list =  map.get(board[r][c]);
        	for(int i=0; i<2; i++) {
        		if(list.get(i).r==r && list.get(i).c==c) find(check,0,board,r,c,board[r][c],i);
        	}
        	
        }
        
        return min;
    }
	
	private static void find(boolean [] check, int cnt, int [][] board, int sr, int sc, int idx, int idx1) {
		if(checking(check)) {
			min = Math.min(min,cnt);
			return;
		}
		// 새로운 패 찾을 때
		if(idx==0) {
			for(int i=1; i<check.length; i++) {
				if(!check[i]) {
					Dot d1 = map.get(i).get(0);
					Dot d2 = map.get(i).get(1);
					int cnt1 = minumum(sr, sc, d1.r, d1.c, board);
					int cnt2 = minumum(sr, sc, d2.r, d2.c, board);
					find(check,cnt+cnt1,board,d1.r,d1.c,i,0);
					find(check,cnt+cnt2,board,d2.r,d2.c,i,1);
				}
			}
		}
		// 짝 찾을 때
		else {
			Dot d = map.get(idx).get(1-idx1);
			int cnt1 = minumum(sr, sc, d.r, d.c, board);
			int [][] cb = copy(board);
			cb[sr][sc] = 0;
			cb[d.r][d.c] = 0;
			check[idx] = true;
			find(check,cnt+cnt1+2,cb,d.r,d.c,0,0);
			cb[sr][sc] = idx;
			cb[d.r][d.c] = idx;
			check[idx] = false;
		}
	}
	
	private static boolean checking(boolean [] check) { // 모든 짝을 다 찾았는지 검수
		for(int i=1; i<check.length; i++) 
			if(!check[i]) return false;
		return true;
	}
	
	private static int minumum(int sr, int sc, int er, int ec, int [][] board) { // 두 카드 사이의 가장 짧은 방법
		int min = 987654321;
		boolean [][] visited = new boolean[4][4];
		
		Queue<int []> q = new LinkedList<>();
		int [] ar = new int [3];
		ar[0] = sr; ar[1] = sc; ar[2] = 0;
		q.add(ar);
		visited[sr][sc] = true;
		
		while(!q.isEmpty()) {
			int [] arr = q.poll();
			int r = arr[0];
			int c = arr[1];
			int cnt = arr[2];
			
			if(r==er && c==ec) { // 목표지점 도착
				min = Math.min(min, cnt);
				continue;
			}
			
			for(int dir=0; dir<8; dir++) {
				int nr=0, nc=0;
				if(dir<4) {
					nr = r + dr[dir];
					nc = c + dc[dir];
				}
				else {
					Dot d = ctrl(dir%4, new Dot(r,c), board);
					nr = d.r;
					nc = d.c;
				}
				if(nr<0 || nc<0 || nr>=4 || nc>=4 || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				int [] a = new int [3];
				a[0] = nr; a[1] = nc; a[2] = cnt+1;
				q.add(a);
				
			}
		}
		return min;
	}
	
	private static Dot ctrl(int dir, Dot d, int [][] board) {
		int r = d.r;
		int c = d.c;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr<0 || nc<0 || nr>=4 || nc>=4) return new Dot(r,c);
			if(board[nr][nc]!=0) return new Dot(nr,nc);
			r = nr;
			c = nc;
		}
		return d;
	}
	
	private static int [][] copy(int [][] board){
		int [][] cb = new int [4][4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				cb[i][j] = board[i][j];
			}
		}
		return cb;
	}
}
