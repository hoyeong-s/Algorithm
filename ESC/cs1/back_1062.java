package cs1;

import java.io.*;
import java.util.*;

public class back_1062 {
	static int N,K;
	static String [] save;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		save = new String[N];
		
		if(K<5) {
			System.out.println(0);
			System.exit(0);
		}else if(K==26) {
			System.out.println(N);
			System.exit(0);
		}else {
			
		}
		
	}

}
