import java.io.*;
import java.util.*;

public class sw_5658 {
	static int N,K,lng;
	static HashMap<Character, Integer> map = new HashMap<>();
	static char [] secret;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		map.put('A', 10);
		map.put('B', 11);
		map.put('C', 12);
		map.put('D', 13);
		map.put('E', 14);
		map.put('F', 15);
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			lng = N/4;
			
			secret = new char[N+lng-1];
			String str = br.readLine();
			for(int i=0; i<N; i++) {
				secret[i+lng-1] = str.charAt(i);
			}
			for(int i=lng-2; i>=0; i--) {
				secret[i] = secret[N+i];
			}
			find();
			for(int i=0; i<K-1; i++) pq.poll();
			sb.append("#"+t+" "+pq.poll()+"\n");
			pq.clear();
		}
		System.out.println(sb);
	}
	private static void find() {
		int cnt=1, sum=0, num=0;
		
		for(int i=lng-1; i>=0; i--) { // 3번 반복
			for(int j=i; j<N+i; j++) { // i 부터 시작
				char s = secret[j];
				if(Character.isAlphabetic(s)) num = map.get(s);
				else num = s-'0';
				
				sum += num*Math.pow(16, lng-cnt);
				cnt++;
				if(cnt==lng+1) {
					if(!pq.contains(sum)) pq.add(sum);
					sum=0;
					cnt=1;
				}
			}
		}
	}
}
