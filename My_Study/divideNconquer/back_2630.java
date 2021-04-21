package divideNconquer;

import java.io.*;
import java.util.*;

public class back_2630 {
	static int N,white,blue;
	static int [][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		find(0,0,N);
		System.out.println(white);
		System.out.println(blue);
		
	}
	private static void find(int r, int c, int n) {
		int cnt=0;
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(map[i][j]==0)cnt++;
			}
		}
		
		if(cnt==n*n) white++;
		else if(cnt==0) blue++;
		else {
			n = n/2;
			find(r,c,n);
			find(r+n,c,n);
			find(r,c+n,n);
			find(r+n,c+n,n);
		}
	}
}
