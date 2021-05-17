package week2;

import java.io.*;
import java.util.*;

public class back_2606 {
	static int N,M;
	static boolean [] check;
	static ArrayList<Integer> [] list;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());		
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			list[i] = new ArrayList<>();
		check = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list[f].add(t);
			list[t].add(f);
		}
		
		virus();
		int cnt=0;
		if(N==1) {
			System.out.println(0);
			System.exit(0);
		}
		
		for(int i=2; i<=N; i++) {
			if(check[i]) cnt++;
		}
		System.out.println(cnt);
	}
	private static void virus() {
		q.add(1);
		check[1] = true;
		
		while(!q.isEmpty()) {
			int f = q.poll();
			
			for(int i=0; i<list[f].size(); i++) {
				int t = list[f].get(i);
				if(!check[t]) {
					check[t] = true;
					q.add(t);
				}
			}
		}
	}
}
