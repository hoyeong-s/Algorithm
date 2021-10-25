import java.io.*;
import java.util.*;

public class september_week9 {
	static int [] p;
	public static void main(String[] args) {
		int n = 6;
		int [][] wires = {{1,4},{6,3},{2,5},{5,1},{5,3}};
		System.out.println(solution(n,wires));
	}
	private static int solution(int n, int[][] wires) {
        p = new int [n+1];
        
        int min = 987654321;
        for(int k=0; k<wires.length; k++) {
        	for(int i=1; i<=n; i++) // 초기화
        		p[i] = i;
        	
        	for(int i=0; i<wires.length; i++) {
        		if(i==k) continue;
        		
        		union(wires[i][0],wires[i][1]);
        	}
        	min = Math.min(count(), min);
        }
        return min;
    }
	private static int find(int x) {
		if(p[x]==x) return x;
		return p[x] = find(p[x]);
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) {
			p[y] = x;
		}else {
			p[x] = y;
		}
	}
	private static int count() {
		int [] check = new int [p.length];
		for(int i=1; i<p.length; i++) {
			p[i] = find(i);
		}
		for(int i=1; i<p.length; i++) {
			check[p[i]]++;
		}
		int a = -1, b=-1;
		for(int i=1; i<p.length; i++) {
			if(check[i]!=0 && a==-1) a= check[i];
			else if(check[i]!=0 && a!=-1) b = check[i];
		}
		return Math.abs(a-b);
	}
}
