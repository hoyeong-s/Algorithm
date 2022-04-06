import java.util.*;

import com.sun.xml.internal.ws.api.server.Container;

import java.io.*;

public class back_1966 {
	
	static class Dot{
		int idx, num;

		public Dot(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<Dot> q = new LinkedList<>();
			ArrayList<Integer> list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int n = Integer.parseInt(st.nextToken());
				q.add(new Dot(j,n));
				if(!list.contains(n)) list.add(n); 
			}
			
			Collections.sort(list, Collections.reverseOrder());
			
			int index = 0;
			int cnt = 1;
			outloop : while(!q.isEmpty()) {
				int size = q.size();
				int out_num = list.get(index++);
				for(int j=0; j<size; j++) {
					Dot d = q.poll();
					if(d.num==out_num) {
						if(d.idx == M) {
							System.out.println(cnt);
							break outloop;
						}
						cnt++;
					}
					else {
						q.add(d);
					}
				}
			}
		}
		
		
	}

}
