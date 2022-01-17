package KAKAO_BLIND_RECRUITMENT_2019;

import java.util.*;

public class 길_찾기_게임 {
	static class Dot implements Comparable<Dot>{
		int r,c;
		
		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public int compareTo(Dot o) {
			return this.r - o.r;
		}
		
	}
	public static void main(String[] args) {

	}
	
	public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        
        for(int i=0; i<nodeinfo.length; i++) {
        	
        }
        return answer;
    }

}
