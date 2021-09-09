import java.io.*;
import java.util.*;

class comp implements Comparable<comp>{
	int num, over, weight;
	double rate;
	
	public comp(int num, int over, int weight, double rate) {
		super();
		this.num = num;
		this.over = over;
		this.weight = weight;
		this.rate = rate;
	}

	@Override
	public int compareTo(comp o) {
		if(this.rate > o.rate) return -1;
		else if (this.rate < o.rate) return 1;
		else {
			if(this.over > o.over) return -1;
			else if (this.over < o.over) return 1;
			else {
				if(this.weight > o.weight) return -1;
				else if (this.weight < o.weight) return 1;
				else {
					if(this.num > o.num) return 1;
					else  return -1;
				}
			}
		}
	} 
	
}
public class september_week6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] weights = {50,82,75,120};
		String [] head2head = {"NLWL","WNLL","LWNW","WWLN"};
		solution(weights,head2head);
	}
	public static int[] solution(int[] weights, String[] head2head) {
        int lng = weights.length;
        char [][] map = new char[lng][lng];
        PriorityQueue<comp> pq = new PriorityQueue<>();
        int [] answer = new int [lng];
        
        for(int i=0; i<lng; i++) {
        	int cnt = 0, over=0, match=0;
        	String str = head2head[i];
        	for(int j=0; j<lng; j++) {
        		map[i][j] = str.charAt(j);
        		if(map[i][j]!='N') match++;
        		if(map[i][j]=='W') {
        			cnt++;
        			if(weights[j]>weights[i]) over++;
        		}
        	}
        	double rate = 0;
        	if(cnt!=0) rate = (double)cnt/(double)match;
        	pq.add(new comp(i+1,over,weights[i],rate));
        }
        
        int cnt = 0;
        while(!pq.isEmpty()) {
        	answer[cnt] = pq.poll().num;
        	cnt++;
        }
        return answer;
    }
}
