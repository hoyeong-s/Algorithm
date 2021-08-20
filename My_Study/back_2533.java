import java.io.*;
import java.util.*;

public class back_2533 {
	static int N;
	static int [] check;
	static ArrayList<Integer> [] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			list[i] = new ArrayList<>();
		check = new int [N+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		dfs(check);
	}
	private static void dfs(int [] check) {
		
	}
}
