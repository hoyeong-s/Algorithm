package week3;

import java.util.*;
import java.io.*;

public class back_1342_np {
	static int N;
	static char [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = str.length();
		
		arr = str.toCharArray();
		
		Arrays.sort(arr);
		
		int cnt=0;
		outloop:do {
			for(int i=0; i<N-1; i++) {
				if(arr[i]==arr[i+1]) continue outloop;
			}
			cnt++;
		}while(np());
		System.out.println(cnt);
	}
	private static boolean np() {
		int i = N-1;
		while(i>0 && arr[i-1]>=arr[i]) --i;
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) --j;
		
		swap(i-1,j);
		
		int k = N-1;
		while(i<k) {
			swap(i++,k--);
		}
		return true;
	}
	private static void swap(int a, int b) {
		char cur = arr[a];
		arr[a] = arr[b];
		arr[b] = cur;
	}
}
