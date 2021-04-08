package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2512 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int high=0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			high = Math.max(arr[i], high);
		}
		int M = Integer.parseInt(br.readLine());
		
		int low=1, result=0;
		while(low<=high) {
			int mid = (low+high)/2;
			
			int sum=0;
			for(int i=0; i<N; i++) {
				if(mid<arr[i]) sum+=mid;
				else sum+=arr[i];
			}
			
			if(sum>M) high=mid-1;
			else if(sum<M) {
				result = mid;
				low = mid+1;
			}
			else {
				result = mid;
				break;
			}
		}
		System.out.println(result);
	}

}
