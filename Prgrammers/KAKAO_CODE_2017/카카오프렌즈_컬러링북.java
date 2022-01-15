package KAKAO_CODE_2017;
import java.util.*;
public class 카카오프렌즈_컬러링북 {
	static int cnt, max, row, col;
    static int [][] p;
    static boolean [][] visited;
    final static int [] dr = {0,0,-1,1};
    final static int [] dc = {-1,1,0,0};
	public static void main(String[] args) {

	}
	public static int[] solution(int m, int n, int[][] picture) {
        int [] answer = new int [2];
        
        p = picture;
        row = m;
        col = n;
        visited = new boolean [row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    cnt ++;
                    max = Math.max(max,bfs(i,j,picture[i][j]));
                }
            }
        }
        answer[0] = cnt;
        answer[1] = max;
        return answer;
    }
    private static int bfs(int rr, int cc, int num){
        Queue<int []> q = new LinkedList<>();
        int [] start = {rr,cc};
        q.add(start);
        visited[rr][cc] = true;
        int cnt = 1;
                
        while(!q.isEmpty()){
            int [] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            
            for(int dir=0; dir<4; dir++){
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if(nr<0 || nc<0 || nr>=row || nc>=col) continue;
                if(p[nr][nc]==num && !visited[nr][nc]){
                    cnt ++;
                    visited[nr][nc] = true;
                    int [] narr = {nr,nc};
                    q.add(narr);
                }
            }
        }
        return cnt;
    }
}
