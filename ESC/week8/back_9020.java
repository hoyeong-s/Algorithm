package week8;

import java.io.*;
import java.util.*;

public class back_9020 {
	static int N;
	static boolean [] prime =new boolean[10001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		prime[0] = prime[1] = true;
		for(int i=2; i*i<=10000; i++) {
			for(int j=i*i; j<=10000; j+=i) {
				prime[j] = true;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			int [] result = new int [2];
			for(int i=2; i<N; i++) {
				if(!prime[i] && !prime[N-i]) {
					if(result[0]!=0) {
						if(Math.abs(result[0]-result[1])>Math.abs(N-2*i)) {
							result[0] = i;
							result[1] = N-i;
						}
					}
					else {
						result[0] = i;
						result[1] = N-i;
					}
				}
			}
			Arrays.sort(result);
			sb.append(result[0]+" "+result[1]+"\n");
		}
		System.out.println(sb);
	}

}
