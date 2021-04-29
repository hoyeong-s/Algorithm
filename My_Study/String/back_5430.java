package String;

import java.io.*;
import java.util.*;

public class back_5430 {
	static int N;
	static String p;
	static Deque<Integer> d = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			p = br.readLine();
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(),"[],");
			for(int i=0; i<N; i++) {
				int num = Integer.parseInt(st.nextToken());
				d.add(num);
			}
			
			AC();
			d.clear();
		}
		System.out.println(sb);
	}
	private static void AC() {
		boolean check = false; // check가 false 정방향, true 역방향
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i)=='R') {
				if(check) check = false;
				else check = true;
			}
			else if(p.charAt(i)=='D') {
				if(d.isEmpty()) {
					sb.append("error\n");
					return;
				}
				else {
					if(check) d.pollLast();
					else d.pollFirst();
				}
			}
		}
		sb.append("[");
		int size = d.size();
		if (!check) {
			for (int i = 0; i < size; i++) {
				sb.append(d.pollFirst());
				if (i == size - 1)
					break;
				sb.append(",");
			}
		}
		else {
			for (int i = 0; i < size; i++) {
				sb.append(d.pollLast());
				if (i == size - 1)
					break;
				sb.append(",");
			}
		}
		sb.append("]\n");
	}
}
