package kakao_210509_intern;

import java.util.*;
import java.io.*;

public class second {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
				{"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, 
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		solution(places);
		}

	
    public static int[] solution(String[][] places) {
        int[] answer = new int [5];
        
        for(int t=0; t<5; t++) {
        	char [][] map = new char[5][5];
        	for(int i=0; i<5; i++) {
        		String str = places[t][i];
        		for(int j=0; j<5; j++) {
        			map[i][j] = str.charAt(j);
        		}
        	}
        	answer[t]=bfs(map);
        }
        return answer;
    }
    
    public static int bfs(char [][] map) {
    	final int [] dr = {0,1,2,0,1,-1};
    	final int [] dc = {1,0,0,2,1,1};
    	
    	for(int r=0; r<5; r++) {
    		for(int c=0; c<5; c++) {
    			if(map[r][c]=='P') {
    				
    				for(int dir=0; dir<=5; dir++) {
    					int nr = r + dr[dir];
    					int nc = c + dc[dir];
    					
    					if(nr<0 || nc<0 || nr>=5 || nc>=5) continue;
    					if(map[nr][nc]=='P') {
    						if(dir<2) return 0;
    						else if(dir==2 && map[r+1][c]=='O') return 0;
    						else if(dir==3 && map[r][c+1]=='O') return 0; 
    						else if(dir == 4){ // 대각선 1일
    							if(map[r][c+1]=='O' || map[r+1][c]=='O') return 0;
    						}
    						else if(dir==5) {
    							if(map[r][c+1]=='O' || map[r-1][c]=='O') return 0;
    						}
    					}
    				}
    			}
    		}
    	}
    	return 1;
    }
}
