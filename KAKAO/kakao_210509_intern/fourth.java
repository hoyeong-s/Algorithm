package kakao_210509_intern;

import java.util.*;
import java.io.*;

class Dot2 implements Comparable<Dot2>{
	int next,wei;
	boolean check;
	
	public Dot2(int next, int wei, boolean check) {
		super();
		this.next = next;
		this.wei = wei;
		this.check = check;
	}

	@Override
	public int compareTo(Dot2 o) {
		return this.next - o.next;
	}
}
public class fourth {
     static PriorityQueue<Dot2> pq = new PriorityQueue<>();
     static int result = 987654321;
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int start = 1;
		int end = 4;
		int [][] roads = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
		int [] traps = {2,3};
		System.out.println(solution(n,start,end,roads,traps));
	}
	
	public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        ArrayList<Dot2> [] list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<roads.length; i++) {
        	int s = roads[i][0];
        	int e = roads[i][1];
        	int l = roads[i][2];
        	list[s].add(new Dot2(e,l,false));
        	list[e].add(new Dot2(s,l,true));
        }
        
        boolean [] trap = new boolean[n+1];
        for(int i=0; i<traps.length; i++)
        	trap[traps[i]] = true;
        
        dijk(list,start,0,end,trap);
        
        answer = result;
        return result;
    }
	
	public static void dijk(ArrayList<Dot2> [] list, int cur, int wei, int end, boolean [] trap) {		
		if (wei >= result)
			return;
		if (cur == end) {
			result = Math.min(result, wei);
			return;
		}
			
		for (int i = 0; i < list[cur].size(); i++) {
			int next = list[cur].get(i).next;
			if(trap[cur]) { // 현재 위치가 폭탄이라면 
				if(list[cur].get(i).check) {
					list[cur].get(i).check = false;
					int idx = list[next].indexOf(cur);
				}
				else list[cur].get(i).check = true;
			}
			
			if(!list[cur].get(i).check) {
			next = list[cur].get(i).next;
			int nwei = wei + list[cur].get(i).wei;
			dijk(list,next,nwei,end,trap);
			}
		}
	}
}

