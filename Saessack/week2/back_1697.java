package week2;

import java.io.*;
import java.util.*;

public class back_1697 {
	static int N,K;
	static Queue<Integer> q = new LinkedList<>();
	static int [] visited = new int [100001];;
	final static int [] dr= {-1,1,2};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Arrays.fill(visited, -1);
		
		if(N==K) {
			System.out.println(0);
			System.exit(0);
		}
		
		q.add(N);
		find();
	}
	
	private static void find() {
		visited[N] = 0;
		
		while(!q.isEmpty()) {
			int r = q.poll();
			
			if(r==K) {
				System.out.println(visited[r]);
				System.exit(0);
			}
			
			for(int dir=0; dir<3; dir++) {
				int nr = 0;
				if(dir<2) nr = r + dr[dir];
				else nr = r*dr[dir];
				if(nr<0 || nr>100000 || visited[nr]!=-1) continue;
				visited[nr] = visited[r]+1;
				q.add(nr);
			}
		}
	}
}
