package Dev_matching_2021;

// 최하위 노드를 찾아서 진행했는데 그럴 필요가 없었음.

import java.io.*;
import java.util.*;

public class 다단계_칫솔_판매 {
	static int N;
	static int [] depth, money;
	static HashMap<String, Integer> map = new HashMap<>();
	static ArrayList<Integer> [] list, list1;
	static Queue<Integer> q = new LinkedList<>();
	static PriorityQueue<Pare> pq = new PriorityQueue<>();
	
	static class Pare implements Comparable<Pare>{
		String seller;
		int amount;
		
		public Pare(String seller, int amount) {
			super();
			this.seller = seller;
			this.amount = amount;
		}

		@Override
		public int compareTo(Pare o) {
			return depth[map.get(o.seller)]-depth[map.get(this.seller)];
		}
	}
	
	public static void main(String[] args) {
		String [] e = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String [] r = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String [] s = {"young", "john", "tod", "emily", "mary"};
		int [] a = {12, 4, 2, 5, 10};
		solution(e,r,s,a);
	}
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        
        N = enroll.length;
        depth = new int [N];
        money = new int [N];
        
        for(int i=0; i<N; i++) {
        	map.put(enroll[i], i);
        }
                
        list = new ArrayList[N];
        list1 = new ArrayList[N];
        for(int i=0; i<N; i++) {
        	list[i] = new ArrayList<>();
        	list1[i] = new ArrayList<>();
        }
        	
        for(int i=0; i<N; i++) {
        	String p = referral[i];
        	if(!p.equals("-")) {
        		list[i].add(map.get(p));
        		list1[map.get(p)].add(i);
        	}
        	else {
        		q.add(i);
        	}
        	
        }
        
        find();
        
        for(int i=0; i<seller.length; i++)
        	pq.add(new Pare(seller[i],amount[i]));
        
        
        while(!pq.isEmpty()) {
        	Pare p = pq.poll();
        	divide(map.get(p.seller),p.amount*100);
        }
        
        return money;
    }
	private static void find() { // 깊이 찾기
		
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int i=0; i<list1[p].size(); i++) {
				int s = list1[p].get(i);
				depth[s] = depth[p]+1;
				q.add(s);
			}
		}
	}
	
	private static void divide(int s, int sum) { // 수익 분배
		if(sum<10) { // 10%가 1원 미만인 경우
			money[s] += sum;
			return; 
		}
		money[s] += sum - (sum/10);
		if(list[s].size()==0) return;
		int p = list[s].get(0);
		divide(p,sum/10);		
	}
}
