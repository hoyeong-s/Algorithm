package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2805 {
	static int N;
	static long M;
	static long [] tree;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new long[N];
		
		long high=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			high = Math.max(high, tree[i]);
		}
		
		long low=0, result=0;;
		while(low<=high) {
			long mid = (low+high) / 2; // 절단기에 설정 높이
			long sum=0;
			for(int i=0; i<N; i++) {
				if(tree[i]>mid) sum+=tree[i]-mid;
			}
			
			if(sum>=M) { // 가져갈 수 있을 때
				result = Math.max(result, mid);
				low = mid+1;
			}
			else high = mid-1;
		}
		
		System.out.println(result);
	}

}
