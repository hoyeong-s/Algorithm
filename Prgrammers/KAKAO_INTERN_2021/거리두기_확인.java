package KAKAO_INTERN_2021;

public class 거리두기_확인 {
	final static int [] dr = {0,1,1,1,0,2};
	final static int [] dc = {1,0,-1,1,2,0}; // 
	
	public static void main(String[] args) {
		String [][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		solution(places);
	}
	
	public static int[] solution(String[][] places) {
        int[] answer = new int [places.length];
                       
        for(int i=0; i<places.length; i++) {
        	answer[i] = checking(places[i]);
        }
        return answer;
    }
	
	private static int checking(String [] place) {
		char [][] map = new char [5][5];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				map[i][j] = place[i].charAt(j);
			}
		}
		
		return check(map);
	}
	
	private static int check(char [][] map) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(map[i][j]=='P') {
					for(int dir = 0; dir<6; dir++) {
						int nr = i + dr[dir];
						int nc = j + dc[dir];
						if(nr<0 || nc<0 || nr>=5 || nc>=5) continue;
						if(map[nr][nc]=='P') {
							if(dir<2) return 0; // 바로 옆에 사람 있는 경우
							if(dir<4 && (map[nr][j]=='O' || map[i][nc]=='0')) return 0;
							if(map[nr][nc]=='P' && map[(nr+i)/2][(nc+j)/2]=='O')	return 0;						
						}
					}
				}
			}
		}
		return 1;
	}
}
