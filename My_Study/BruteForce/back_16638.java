package BruteForce;

import java.io.*;
import java.util.*;

public class back_16638 {
	static int N,result=-999999999;
	static char[] arr;
	static ArrayList<Integer> list = new ArrayList<>();
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		arr = str.toCharArray();
		
		for(int i=0; i<N; i++) 
			if(str.charAt(i)=='+' || str.charAt(i)=='-') list.add(i);
		
		int n = list.size();
		outloop:for(int i=0; i<(1<<n); i++) {
			for(int j=0; j<n-1; j++) {
				if((i&(1<<j))!=0 && (i&(1<<(j+1)))!=0) {
					if(list.get(j+1)-list.get(j)<=2) continue outloop;
				}
			}
			q.clear();
			for(int j=0; j<n; j++) {
				if((i&(1<<j))!=0) q.add(list.get(j));
			}
			
			result = Math.max(result, first());
		}
		System.out.println(result);
	}

	private static int cal(int a, char c, int b) {
		if(c=='+') return a+b;
		else if(c=='-') return a-b;
		else return a*b;
	}
	
	private static int first() { // 괄호 계산
		int [] f = new int [N];
		boolean [] bool = new boolean[N];
		
		for(int i=0; i<N; i++) { // arr_i 만들기
			if(Character.isDigit(arr[i])) f[i] = arr[i]-'0'; // 숫자면 숫자
			else {
				if(q.contains(i)) f[i] = -1;
				else if(arr[i]!='*') f[i] = 2;
				else f[i] = 1;
			}
		}
		
		for(int i=0; i<N; i++) { // 괄호 먼저 계산
			if(i%2==1 && f[i]==-1) {
				int c = cal(f[i-1],arr[i],f[i+1]);
				f[i-1] = c;
				bool[i] = true;
				bool[i+1] = true;
			}
		}
		
		for(int i=0; i<N; i++) { // 곱셈 계산
			if(i%2==1 && f[i]==1) {
				int j = i-1;
				while (bool[j]) j -= 2;
				int c = cal(f[j], '*', f[i + 1]);
				f[j] = c;
				bool[i] = true;
				bool[i + 1] = true;
				
			}
		}
				
		for(int i=0; i<N; i++) { // 플러스 마이너스 계산 
			if(i%2==1 && f[i]==2) {
				int j = i-1;
				while (bool[j]) j -= 2;
				int c = cal(f[j], arr[i], f[i + 1]);
				f[j] = c;
				bool[i] = true;
				bool[i + 1] = true;
			}
		}
		
		return f[0];
	}
}
