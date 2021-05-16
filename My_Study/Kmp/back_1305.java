package Kmp;

import java.io.*;
import java.util.*;

public class back_1305 {
	static int N;
	static String str;
	static int [] table;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		table = new int [N];
		
		make();
		/*int max=0;
		for(int x:table)
			max = Math.max(max, x);*/
		System.out.println(N-table[N-1]);
	}
	private static void make() {
		int j=0;
		for(int i=1; i<str.length(); i++) {
			while(j>0 && str.charAt(i)!=str.charAt(j))
				j = table[j-1];
			if(str.charAt(i)==str.charAt(j))
				table[i] = ++j;	
		}
	}
}
