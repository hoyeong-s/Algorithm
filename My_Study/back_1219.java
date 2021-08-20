import java.io.*;
import java.util.*;

class b_1219{
	int s,e,wei;

	public b_1219(int s, int e, int wei) {
		super();
		this.s = s;
		this.e = e;
		this.wei = wei;
	}
}
public class back_1219 {
	static int N,Start,Dest,M,INF=987654321;
	static int [] cost,dis;
	static b_1219 [] list;
	static ArrayList<b_1219> [] alist;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Start = Integer.parseInt(st.nextToken());
		Dest = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new b_1219 [M];
		alist = new ArrayList[N];
		for(int i=0; i<N; i++) {
			alist[i] = new ArrayList<>();
		}
		cost = new int [N];
		dis = new int [N];
		Arrays.fill(dis, INF);
				
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			alist[s].add(new b_1219(s, e, -wei));
			list[i] = new b_1219(s, e, wei); 
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			cost[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			list[i] = new b_1219(list[i].s, list[i].e, cost[list[i].e]-list[i].wei);
		}
				
		BF();
		System.out.println(0);
		
	}
	private static void bfs() { 
		
	}

	private static boolean BF() {
		boolean [] visited = new boolean [N];
		Arrays.fill(visited, false);
		dis[Start] = 0;

		for (int i = 0; i < N; i++) {
			Arrays.fill(visited, false);
			visited[Start] = true;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < alist[j].size(); k++) {
					b_1219 b = alist[j].get(k);
					int next = b.e;
					int wei = b.wei;

					if (dis[next] > dis[j] + wei && !visited[next]) {
						{
							if (dis[next] < 0 && dis[j] + wei < 0)
								dis[next] = Math.max(dis[next], dis[j] + cost[next] + wei);
							else
								dis[next] = dis[j] + cost[next] + wei;
						}
						if (i == N - 1)
							return true;
					}
				}
			}
		}
		return false;
	}

}
