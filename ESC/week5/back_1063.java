package week5;

import java.io.*;
import java.util.*;

public class back_1063 {
	static HashMap<String, Integer> hash = new HashMap<>();
	static int N,kr,kc,rr,rc;
	static int [][] map = new int [8][8];
	static Queue<Integer> q = new LinkedList<>();
	final static int [] dr = {0,0,0,1,-1,-1,-1,1,1};
	final static int [] dc = {0,1,-1,0,0,1,-1,1,-1 };
	
	
	public static void main(String[] args) throws IOException {
		hash.put("R", 1);
		hash.put("L", 2);
		hash.put("B", 3);
		hash.put("T", 4);
		hash.put("RT", 5);
		hash.put("LT", 6);
		hash.put("RB", 7);
		hash.put("LB", 8);
				
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	String king = st.nextToken();
	kc = king.charAt(0) -'A';
	kr = 7-(king.charAt(1) - '1');
		
	String rock = st.nextToken();
	rc = rock.charAt(0) -'A';
	rr = 7-(rock.charAt(1) - '1');
	
	map[rr][rc] = -1; // 돌의 위치 -1
	
	N = Integer.parseInt(st.nextToken());
	for(int i=0; i<N; i++) {
		String str = br.readLine();
		q.add(hash.get(str));
	}
	
	move();
	
	StringBuilder sb = new StringBuilder();
	// 구한 위치 알파벳으로 변환 시키기
	char a = (char)(kc + 'A');
	int b = 8 - kr;
	sb.append(a);
	sb.append(b+"\n");
	char c = (char)(rc + 'A');
	int d = 8 - rr;
	sb.append(c);
	sb.append(d+"\n");
	
	System.out.println(sb);
	
	}
	private static void move() {
		while(!q.isEmpty()) {
			int dir = q.poll();
			int nr = kr + dr[dir];
			int nc = kc + dc[dir];
			if(nr<0 || nc<0 || nr>=8 || nc>=8) continue;
			
			if(map[nr][nc]==-1) { // 돌이 있는 경우
				int nrr = rr + dr[dir];
				int nrc = rc + dc[dir];
				if(nrr<0 || nrc<0 || nrr>=8 || nrc>=8) continue;
				map[rr][rc]=0;
				map[nrr][nrc]=-1;
				rr = nrr;
				rc = nrc;
			}
			
			kr = nr;
			kc = nc;
			
		}
	}
}
