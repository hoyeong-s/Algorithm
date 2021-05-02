package week6;
import java.io.*;
import java.util.*;

public class back_2846 {
	static int N,result;
	static int [] road;
	static boolean [] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		road = new int [N];
		check = new boolean [N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N-1; i++) {
			if(road[i+1]>road[i]) check[i] = true;
		}
		
		find();
		System.out.println(result);
	}
	private static void find() {
		int i=0;
		outloop:while(i!=N-1) {
			if(check[i]) {
				int j=i+1;
				while(check[j]) {
					j++;
				}
				result = Math.max(result, road[j]-road[i]);
				i=j;
				continue outloop;
			}
			i++;
		}
	}
}
