package String;

import java.util.*;
import java.io.*;

public class back_6137 {
	static int N;
	static char [] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N];
		
		for(int i=0; i<N; i++)
			arr[i] = br.readLine().charAt(0);
		
		pointer();
		System.out.println(sb);	
	}
	private static void pointer() {
		int i=0, j=N-1;
		outloop:while(i<=j) {
			while(i<=j) {
				if(sb.length()>0 && sb.length()%80==0) {
					System.out.println(sb);
					sb = new StringBuilder();
				}
				int a = arr[i];
				int b = arr[j];
				
				if(a<b) {				// 앞쪽
					sb.append(arr[i]);
					break;
				}
				else if(a>b) {			// 뒷쪽
					sb.append(arr[j]);
					j--;
				}
				else {					// 같을때
					int m=i,n=j;
					while(m<n && arr[m]==arr[n]) {
						m++;
						n--;
					}
					a = arr[m];
					b = arr[n];
					if(a<b) {				// 앞쪽
						sb.append(arr[i]);
						break;
					}
					else if(a>b) {			// 뒷쪽
						sb.append(arr[j]);
						j--;
					}
					else {
						for(int x=i; x<=j; x++) {
							if(sb.length()>0 && sb.length()%80==0) {
								System.out.println(sb);
								sb = new StringBuilder();
							}
							sb.append(arr[x]);
						}
						break outloop;
					}
				}
			}
			i++;
		}
		
	}
}
