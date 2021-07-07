package cs1;

import java.io.*;
import java.util.*;

class b_17225 implements Comparable<b_17225>{
	int t,c;

	public b_17225(int t, int c) {
		super();
		this.t = t;
		this.c = c;
	}

	@Override
	public int compareTo(b_17225 o) {
		if(this.t==o.t) return this.c - o.c;
		else return this.t - o.t;
	}
}
public class back_17225 {
	static int S,J,N;
	static int [][] save;
	static boolean [] Sang = new boolean [86400];
	static boolean [] Ji = new boolean [86400];
	static PriorityQueue<b_17225> pq = new PriorityQueue<>();
	static Queue<Integer> qs = new LinkedList<Integer>();
	static Queue<Integer> qj = new LinkedList<Integer>();
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		J = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		save = new int [N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			save[i][0] = Integer.parseInt(st.nextToken());
			save[i][1] = (int)st.nextToken().charAt(0);
			save[i][2] = Integer.parseInt(st.nextToken());
		}
		
		present();
		output();
		System.out.println(sb);
	}
	
	private static void present() {
		int s_t=1, j_t=1; // 끝나는 시간
		
		for(int i=0; i<N; i++) {
			int t = save[i][0];
			char c = (char)save[i][1];
			int m = save[i][2];
			
			if(c=='B') { // 상민
				if(s_t>t) { // 현재 주문시간에 예약이 밀린 경우
					for(int j=0; j<m; j++) {
						pq.add(new b_17225(s_t+(S*j), 'B'));
						if(j==m-1) s_t = s_t+(S*m);
					}
				}
				
				else{
					for(int j=0; j<m; j++) {
						pq.add(new b_17225(t+(S*j), 'B'));
						if(j==m-1) s_t = t+(S*m);
					}
				}
			}
			else { // 민지
				if(j_t>t) {
					for(int j=0; j<m; j++) {
						pq.add(new b_17225(j_t+(J*j), 'R'));
						if(j==m-1) j_t = j_t+(J*m);
					}
				}
				
				else {
					for(int j=0; j<m; j++) {
						pq.add(new b_17225(t+(J*j), 'R'));
						if(j==m-1) j_t = t+(J*m);
					}
				}
			}
		}
		
		int cnt = 1;
		while(!pq.isEmpty()) {
			b_17225 b = pq.poll();
			if(b.c=='B') qs.add(cnt++);
			else qj.add(cnt++);
		}
	}
	
	private static void output() {
		sb.append(qs.size()+"\n");
		while(!qs.isEmpty()) sb.append(qs.poll()+" ");
		sb.append("\n");
		sb.append(qj.size()+"\n");
		while(!qj.isEmpty()) sb.append(qj.poll()+" ");
	}
}
