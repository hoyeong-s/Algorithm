package week6;

import java.io.*;
import java.util.*;

class b_9177{
	int r,c;

	public b_9177(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class back_9177 {
	static String str1, str2, str3;
	static boolean [][] visited;
	static StringBuilder sb = new StringBuilder();
	final static int [] dr = {0,1};
	final static int [] dc = {1,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			str1 = st.nextToken();
			str2 = st.nextToken();
			str3 = st.nextToken();
			
			visited = new boolean[str2.length()+1][str1.length()+1];
			move(0,0);
			
			if(visited[str2.length()][str1.length()]) sb.append("Data set "+t+": yes\n");
			else sb.append("Data set "+t+": no\n");
		}
		System.out.println(sb);
	}
	private static void move(int r, int c) {
		
		if(visited[r][c]) return;
		visited[r][c] = true;
		
		if(r<str2.length() && str2.charAt(r)==str3.charAt(r+c)) {
			move(r+1,c);
		}
		
		if(c<str1.length() && str1.charAt(c)==str3.charAt(r+c)) {
			move(r,c+1);
		}
	}
}

// BFS -> 메모리 초과
/*q.add(new b_9177(0,0));

while(!q.isEmpty()) {
	b_9177 b = q.poll();
	int r = b.r;
	int c = b.c;
	
	if(r==str2.length() && c==str1.length()) {
		sb.append("Data set "+test+": yes\n");
		return;
	}
	
	char find = str3.charAt(r+c);
	for(int dir=0; dir<2; dir++) {
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		if(nr > str2.length() || nc > str1.length()) continue;
		if((dir==0 && str1.charAt(nc-1)==find) || (dir==1 && str2.charAt(nr-1)==find)) { 
			q.add(new b_9177(nr, nc));
		}
	}
}
sb.append("Data set "+test+": no\n");*/
