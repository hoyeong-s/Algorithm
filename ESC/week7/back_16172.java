package week7;

import java.io.*;
import java.util.*;

public class back_16172 {
	static String str1,str2,str3;
	static int [] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		str1 = br.readLine();	
		str2 = br.readLine();
		arr = new int [str2.length()];
		
		for(int i=0; i<str1.length(); i++) {
			char a = str1.charAt(i);
			if(Character.isAlphabetic(a)) sb.append(a);
		}
		
		str3 = sb.toString();
		make();
		System.out.println(kmp());
	}
	private static void make() {
		int j=0;
		for(int i=1; i<str2.length(); i++) {
			while(j>0 && str2.charAt(i)!=str2.charAt(j))
				j = arr[j-1]; 
			if(str2.charAt(i)==str2.charAt(j))
				arr[i] = ++j;
		}
	}
	private static int kmp() {
		int j=0;
		for(int i=0; i<str3.length(); i++) {
			while(j>0 && str3.charAt(i)!=str2.charAt(j))
				j = arr[j-1];
			if(str3.charAt(i)==str2.charAt(j)) {
				if(j==str2.length()-1) return 1;
				j++;
			}
		}
		return 0;
	}
}
