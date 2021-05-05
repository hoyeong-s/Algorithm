package LIS;

import java.io.*;
import java.util.*;

public class back_12738 {
	static int N;
	static int [] arr,list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		list = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(LIS()+1);
		
	}
	private static int LIS() {
		int cnt=0;
		list[0] = arr[0];
		for(int i=1; i<N; i++) {
			int cur = arr[i];
			if(cur>list[cnt]) {
				list[++cnt] = cur;
			}
			else {
				int idx = Arrays.binarySearch(list, 0, cnt,cur);
				if(idx<0) idx=-idx-1;
				list[idx] = cur;
			}
		}
		return cnt;
	}
}
