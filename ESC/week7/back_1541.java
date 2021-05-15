package week7;

import java.io.*;
import java.util.*;

public class back_1541 {
	static String str;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		str = br.readLine();
		String[] s = str.split("-");
		
		int result=0;
		
		for(int i=0; i<s.length; i++) {
			int num=0;
			st = new StringTokenizer(s[i],"+");	
			while(st.hasMoreElements()) {
				num += Integer.parseInt(st.nextToken());
			}
			if(i==0) result+=num;
			else result -= num;
		}
		
		System.out.println(result);
	}

}
