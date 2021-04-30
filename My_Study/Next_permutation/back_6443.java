package Next_permutation;

import java.util.*;
import java.io.*;

public class back_6443 {
	static int N;
	static char[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			N = str.length();
			arr = str.toCharArray();
			
			Arrays.sort(arr);
			
			do {
				for(char x:arr) sb.append(x);
				sb.append("\n");
			}while(np());

		}
		System.out.println(sb);
	}
	private static boolean np() {
		int i = N-1;
		while(i>0 && arr[i-1]>=arr[i]) --i;
		if(i==0) return false;
		
		int j=N-1;
		while(arr[i-1] >= arr[j]) --j;
		
		swap(i-1,j);
		
		int k=N-1;
		while(i<k) {
			swap(i++,k--);
		}
		
		return true;
	}
	private static void swap(int i, int j) {
		char cur = arr[i];
		arr[i] = arr[j];
		arr[j] = cur;
	}
}
