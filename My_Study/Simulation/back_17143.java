package Simulation;

import java.io.*;
import java.util.*;

public class back_17143 {
	static int R,C,M,result;
	static int [][] map;
	static int [][] fish;
	final static int [] dr = {0,-1,1,0,0};
	final static int [] dc = {0,0,0,1,-1};
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [R+1][C+1];
		fish = new int [M+1][5];
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = i;
			fish[i][0] = r;
			fish[i][1] = c;
			fish[i][2] = s;
			fish[i][3] = d;
			fish[i][4] = z;
		}
		
		for(int i=1; i<=C; i++) {
			kill(i);
			if(i==C) break;
			move();
		}
		System.out.println(result);
	}
	
	private static void move() { // 물고기 움직이기
		int[][] mapc = new int[R + 1][C + 1];

		for (int i = 1; i <= M; i++) {
			if(fish[i][2]==-1) continue;
			// map을 기준으로 mapc에 물고기 놓기
			// 상 하 우 좌
			// 이미 물고기 있으면 물고기 잡아먹기 -> fish 배열에서도 제거 해줘야함(fish[num][0] = -1)
			int r = fish[i][0];
			int c = fish[i][1];
			int dir = fish[i][3];
			for (int j = 0; j < fish[i][2]; j++) {

				if (r == 1 && dir == 1)
					dir++;
				else if (c == 1 && dir == 4)
					dir--;
				else if (r == R && dir == 2)
					dir--;
				else if (c == C && dir == 3)
					dir++;

				int nr = r + dr[dir];
				int nc = c + dc[dir];

				r = nr;
				c = nc;
			}
			
			if (mapc[r][c] != 0) { // 이미 물고기가 있을 때
				int al = mapc[r][c];
				if (fish[i][4] > fish[al][4]) { // 새로 들어온 물고기가 더 큰 경우
					fish[al][2] = -1;
				} else { // 원래 물고기가 더 큰 경우
					fish[i][2] = -1;
					continue;
				}
			}

			mapc[r][c] = i;
			fish[i][0] = r;
			fish[i][1] = c;
			fish[i][3] = dir;
		}
		map = mapc;
	}
	
	private static void kill(int c) { // map과 list에서 물고기 지우기(list > 0,0,0으로 만들기)
		int get = find(c);
		if(get==0) return;
		else {
			int num = map[get][c];
			map[get][c] = 0;
			result += fish[num][4];
			fish[num][2] = -1;
		}
	}
	
	private static int find(int c) { // 땅과 가장 가까운 물고기 찾기
		for(int i=1; i<=R; i++) {
			if(map[i][c]!=0) return i;
		}
		return 0;
	}

}
