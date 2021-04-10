package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2118 {
	static int N, total,result=0;
	static int [] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int [N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}
		pointer();
		System.out.println(result);
	}
	private static void pointer() {
		int j=0,sum=0;
		outloop:for(int i=0; i<N; i++) {
			sum += arr[i];
			while(j<=i) {
				if(total - sum >= sum) {
					result = Math.max(result, sum);
					continue outloop;					
				}
				else {
					sum-=arr[j];
					j++;
				}
			}
		}
	}
}
