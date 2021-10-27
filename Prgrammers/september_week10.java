import java.io.*;
import java.util.*;

public class september_week10 {
	static int left = Integer.MAX_VALUE,right = Integer.MIN_VALUE,top = Integer.MIN_VALUE,bottom = Integer.MAX_VALUE;
	static ArrayList<Dot> list = new ArrayList<>();
	static class Dot{
		int r, c;

		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		int [][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		System.out.println(solution(line));
	}
	public static String[] solution(int[][] line) {
		StringBuilder sb;
                
        for(int i=0; i<line.length; i++) {
        	for(int j=i; j<line.length; j++) {
        		if(i==j) continue;
        		calc(line[i],line[j]);
        	}
        }
        String [][] map = new String [top-bottom+1][right-left+1];
        
        for(String [] rr : map) {
        	Arrays.fill(rr, ".");
        }
        for(int i=0; i<list.size(); i++) {
        	Dot d = list.get(i);
        	map[d.r-bottom][d.c-left] = "*";
        }
        
        String [] answer = new String[map.length];
        
        for(int i=map.length-1; i>=0; i--) {
        	sb = new StringBuilder();
        	for(int j=0; j<map[i].length; j++) {
        		sb.append(map[i][j]);
        	}
        	answer[map.length-1-i] = sb.toString();
        }
        
        return answer;
    }
	private static void calc(int [] a, int [] b) {
		long A = a[0];
		long B = a[1];
		long E = a[2];
		long C = b[0];
		long D = b[1];
		long F = b[2];
		
		if(A*D == B*C) return;
		long c = (B*F - E*D) / (A*D - B*C);
		long r = (E*C - A*F) / (A*D - B*C);
		if((B*F - E*D) % (A*D - B*C)!=0 || (E*C - A*F) % (A*D - B*C)!=0) return;
		left = Math.min(left, (int)c);
		right = Math.max(right, (int)c);
		top = Math.max(top, (int)r);
		bottom = Math.min(bottom, (int)r);
		list.add(new Dot((int)r,(int)c));
	}
}
