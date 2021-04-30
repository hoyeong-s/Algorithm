package Next_permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_10974 {
	static int N;
	static int [] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = i+1;
		
		do {
			for(int x:arr) sb.append(x+" ");
			sb.append("\n");
		}while(np());
		System.out.println(sb);
	}
	
	private static boolean np() {
		int i=N-1;
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
		int cur = arr[i];
		arr[i] = arr[j];
		arr[j] = cur;
	}
}
