import java.io.*;
import java.util.*;

public class september_week12 {
	static int max=0;
	static int [][] d;
	public static void main(String[] args) {

	}
	public static int solution(int k, int[][] dungeons) {
        int answer = -1;
        d = dungeons;
        
        dfs(new boolean[d.length],0,k);
        return max;
    }
	private static void dfs(boolean [] visited, int cnt, int k) {
		max = Math.max(max, cnt);
		
		for(int i=0; i<visited.length; i++) {
			if(!visited[i] && k>=d[i][0]) {
				visited[i] = true;
				k-=d[i][1];
				dfs(visited,cnt+1,k);
				visited[i] = false;
				k+=d[i][1];
			}
		}
		
	}
}

//import java.io.*;
//import java.util.*;
//
//public class september_week12 {
//	static int max=0;
//	static int [] arr;
//	static int [][] d;
//	public static void main(String[] args) {
//
//	}
//	public static int solution(int k, int[][] dungeons) {
//      int answer = -1;
//      d = dungeons;
//      arr = new int [d.length];
//      for(int i=0; i<d.length; i++) arr[i] = i;
//      
//      while(np()) {
//      	int cnt = 0;
//      	int kk = k;
//      	for(int i=0; i<d.length; i++) {
//      		if(kk>=dungeons[arr[i]][0]) {
//      			cnt++;
//      			kk -= dungeons[arr[i]][1];
//      		}else break;
//      	}
//      	max = Math.max(max, cnt);
//      }
//      return max;
//  }
//	private static boolean np() {
//		int i = d.length-1;
//		while(i>0 && arr[i-1]>=arr[i]) --i; // 꼭대기 찾기
//		if(i==0) return false;
//		
//		int j = d.length-1;
//		while(arr[i-1] >= arr[j]) --j; // 꼭대기 앞과 교환할 위치 찾기
//		
//		swap(i-1,j);
//		
//		int k = d.length-1;
//		while(i<k) {
//			swap(i++,k--); // 가장 작게 만들어주기
//		}
//		return true;
//	}
//	private static void swap(int a, int b) {
//		int cur = arr[a];
//		arr[a] = arr[b];
//		arr[b] = cur;
//	}
//}

