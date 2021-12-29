package KAKAO_BLIND_RECRUITMENT_2020;

public class 외벽_점검 {
	static int min = 987654321;
	static int [] dis, w;
	public static void main(String[] args) {

	}
	public static int solution(int n, int[] weak, int[] dist) {
        dis = dist;
        w = weak;
        
        for(int i=0; i<weak.length-1; i++) {
        	for(int j=i+1; j<weak.length; j++) {
        		find(n,i,j,new boolean[weak.length],new boolean[dist.length],0);
        	}
        }
        
        if(min==987654321) return -1;
        return min;
    }
	
	private static void find(int n, int start, int end, boolean [] wcheck, boolean [] dcheck, int cnt) {
		if(cnt==w.length) {
			int count = 0;
			for(boolean b : dcheck)
				if(b) count++;
			
			min = Math.min(min, count);
			return;
		}
		
		int near = w[end]-w[start];
		int far = n-near;

		for(int i=0; i<dis.length; i++) {
			if(near<=dis[i]) {
				int c = cnt;
				dcheck[i] = true;
				
				for(int j=start; i<=end; i++) {
					wcheck[i] = true;
					c++;
				}
				
				
					
			}
		}
		
		
			
	}
}
