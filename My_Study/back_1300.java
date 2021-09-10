import java.io.*;
import java.util.*;

public class back_1300 {
	static int N;
	static long k;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		k = Long.parseLong(br.readLine());
		
		long low = 1, high = k;
		long result = 0L;
		
		while(low <= high) {
			long mid = (low+high)/2;
			if(find(mid) >= k) {
				result = mid;
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		System.out.println(result);
	}
	private static long find(long mid) {
		long cnt=0L;
		for(int i=1; i<=N; i++) cnt+=Math.min(mid/i, N);
		return cnt;
	}
}
