import java.io.*;
import java.util.*;

public class back_1525 {
	static int r,c;
	static String first = "123456780";
	static int [] dr = {-1,0,0,1};
	static int [] dc = {0,-1,1,0};
	static char [] arr = new char[9];
	static Character [][] map = new Character [3][3];
	static Queue<String> q = new LinkedList<>();
	static HashMap<String, Integer> hash = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<3; i++) {
			String str = br.readLine();
			for(int j=0; j<3; j++) {
				map[i][j] = str.charAt(j*2);
				sb.append(map[i][j]);
			}
		}
		
		hash.put(sb.toString(), 0);
		q.add(sb.toString());
		bfs();
		
		if(hash.containsKey(first)) System.out.println(hash.get(first));
		else System.out.println(-1);
	}
	private static void bfs() {
		
		while(!q.isEmpty()) {
			
			String str = q.poll();
			
			int cur = remake(str); // map 상태 변화 및 현재 0의 위치
			int c = cur%3;
			int r = (cur-c)/3;
			
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=3 || nc>=3) continue;
				
				arr = str.toCharArray();
				
				switch(dir) {
				case 0 : {
					swap(cur-3,cur);
					break;
				}
				case 1 : {
					swap(cur-1,cur);
					break;
				}
				case 2 : {
					swap(cur+1,cur);
					break;
				}
				case 3 : {
					swap(cur+3,cur);
					break;
				}
				}
				
				String nstr = new String(arr);
				
				if(!hash.containsKey(nstr)) {
					q.add(nstr);
					hash.put(nstr, hash.get(str)+1);
				}
			}
		}
	}	
	
	private static void swap(int i, int j) {
		char cur = arr[i];
		arr[i] = arr[j];
		arr[j] = cur;
	}
	
	private static int remake(String str){ // 문자를 배열로 만들기
		int save = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				map[i][j] = str.charAt(i*3+j);
				if(map[i][j]=='0') save = i*3+j;
			}
		}
		return save;
	}
}



//import java.io.*;
//import java.util.*;
//
//public class back_1525 {
//	static int r,c;
//	static String first = "123456780";
//	static int [] dr = {-1,0,0,1};
//	static int [] dc = {0,-1,1,0};
//	static Character [][] map = new Character [3][3];
//	static Queue<String> q = new LinkedList<>();
//	static HashMap<String, Integer> hash = new HashMap<>();
//	
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
//		
//		for(int i=0; i<3; i++) {
//			String str = br.readLine();
//			for(int j=0; j<3; j++) {
//				map[i][j] = str.charAt(j*2);
//				sb.append(map[i][j]);
//			}
//		}
//		
//		if(sb.toString().equals(first)) {
//			System.out.println(0);
//			System.exit(0);
//		}
//		
//		hash.put(sb.toString(), 0);
//		q.add(sb.toString());
//		System.out.println(bfs());
//		
//	}
//	private static int bfs() {
//		
//		while(!q.isEmpty()) {
//			
//			String str = q.poll();
//			
//			int cur = remake(str); // map 상태 변화 및 현재 0의 위치
//			int c = cur%3;
//			int r = (cur-c)/3;
//			
//			for(int dir=0; dir<4; dir++) {
//				int nr = r + dr[dir];
//				int nc = c + dc[dir];
//				if(nr<0 || nc<0 || nr>=3 || nc>=3) continue;
//				
//				StringBuilder sb = new StringBuilder();
//				sb.append(str);
//				
//				switch(dir) {
//				case 0 : {
//					sb.setCharAt(cur-3, '0');
//					sb.setCharAt(cur, map[nr][nc]);
//					break;
//				}
//				case 1 : {
//					sb.setCharAt(cur-1, '0');
//					sb.setCharAt(cur, map[nr][nc]);
//					break;
//				}
//				case 2 : {
//					sb.setCharAt(cur+1, '0');
//					sb.setCharAt(cur, map[nr][nc]);
//					break;
//				}
//				case 3 : {
//					sb.setCharAt(cur+3, '0');
//					sb.setCharAt(cur, map[nr][nc]);
//					break;
//				}
//				}
//				
//				if(sb.toString().equals(first)) return hash.get(str)+1;
//				if(!hash.containsKey(sb.toString())) {
//					q.add(sb.toString());
//					hash.put(sb.toString(), hash.get(str)+1);
//				}
//			}
//		}
//		return -1;
//	}	
//	
//	private static int remake(String str){ // 문자를 배열로 만들기
//		int save = 0;
//		for(int i=0; i<3; i++) {
//			for(int j=0; j<3; j++) {
//				map[i][j] = str.charAt(i*3+j);
//				if(map[i][j]=='0') save = i*3+j;
//			}
//		}
//		return save;
//	}
//}
