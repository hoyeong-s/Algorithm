package KAKAO_CODE_2017;

import java.util.*;

public class 단체사진_찍기 {
	static class Dot implements Comparator<Dot>{
		int r,c;

		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compare(Dot o1, Dot o2) {
			return 0;
		}
		
	}
	static int N;
    static char [] d= {'A','C','F','J','M','N','R','T'};
    
	public static void main(String[] args) {
		String [] data = {"N~F=0", "R~T>2"};
		solution(2,data);
	}
	public static int solution(int n, String[] data) {
        int answer = 0;
        String str="";
        StringTokenizer st = new StringTokenizer(str);
        
        int a = Integer.parseInt(st.nextToken());
        
        N = d.length;
        
        Arrays.sort(d);
        
        do{
            if(check(data)) answer++;
        }while(np());
        
        return answer;
    }
    private static boolean check(String [] data){
        for(int i=0; i<data.length; i++){
            int a_idx=0, b_idx=0;
            for(int j=0; j<d.length; j++){
                if(data[i].charAt(0)==d[j]) a_idx = j;
                if(data[i].charAt(2)==d[j]) b_idx = j;
            }
            int res = data[i].charAt(4)+1-'0';
            if(data[i].charAt(3)=='='){
                if(Math.abs(a_idx-b_idx)!=res) return false;
            }else if(data[i].charAt(3)=='>'){
                if(Math.abs(a_idx-b_idx)<=res) return false;
            }else{
                if(Math.abs(a_idx-b_idx)>=res) return false;   
            }
        }
        return true;
    }
    
    private static boolean np(){
        int i = N-1;
        while(i>0 && d[i-1]>=d[i]) --i;
        if(i==0) return false;
        
        int j = N-1;
        while(d[i-1]>=d[j]) --j;
        
        swap(i-1,j);
        
        int k = N-1;
        while(i<k){
            swap(i++,k--);
        }
        return true;
    }
    
    private static void swap(int a, int b){
        char cur = d[a];
        d[a] = d[b];
        d[b] = cur;
    }
}
