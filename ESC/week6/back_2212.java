package week6;

import java.io.*;
import java.util.*;

public class back_2212 {
	static int N, K;
	static int [] sensor, dif;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		sensor = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			sensor[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(sensor);
		
		dif = new int [N-1];
		for(int i=0; i<N-1; i++)
			dif[i] = sensor[i+1] - sensor[i];
		
		Arrays.sort(dif);
	}

}
