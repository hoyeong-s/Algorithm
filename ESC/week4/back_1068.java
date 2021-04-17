package week4;

import java.util.*;
import java.io.*;

public class back_1068 {
	static int N, sta,del;
	static int [] arr;
	static boolean [] visited; 
	static ArrayList<Integer>[] list;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		del = Integer.parseInt(br.readLine());
		visited[del] = true;
		
		list = new ArrayList[N];
		for(int i=0; i<N; i++)
			list[i] = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			if(arr[i]==-1) {
				sta = i;
				if(sta == del) {
					System.out.println(0);
					System.exit(0);
				}
				continue;
			}
			if(i==del || arr[i]==del) continue;
			list[i].add(arr[i]);
			list[arr[i]].add(i);
		}
		if(list[sta].size()==0) System.out.println(1);
		else System.out.println(find(sta));
	}
	private static int find(int start) {
		q.add(start);
		visited[start] = true;
		int cnt=0;
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int i=0; i<list[node].size(); i++) {
				int next = list[node].get(i);
				if(next==del) continue;
				if(list[node].size()==1 && visited[next]) cnt++;
				if(visited[next]) continue;
				visited[next] = true;
				q.add(next);
			}
		}
		return cnt;
	}
}
