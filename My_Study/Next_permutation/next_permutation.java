package Next_permutation;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class next_permutation {
	static int N;
	static int [] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 4;
		arr= new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		do {
			System.out.println(Arrays.toString(arr));
		}while(np());
		
	}
	private static boolean np() {
		int i = N-1;
		while(i>0 && arr[i-1]>=arr[i]) --i; // 꼭대기 찾기
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) --j; // 꼭대기 앞과 교환할 위치 찾기
		
		swap(i-1,j);
		
		int k = N-1;
		while(i<k) {
			swap(i++,k--); // 가장 작게 만들어주기
		}
		return true;
	}
	private static void swap(int a, int b) {
		int cur = arr[a];
		arr[a] = arr[b];
		arr[b] = cur;
	}
}
