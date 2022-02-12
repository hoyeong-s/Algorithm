package KAKAO_BLIND_RECRUITMENT_2022;

public class 파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        int [][] pref = new int [row+1][col+1];
        
        for(int i=0; i<skill.length; i++){
            int degree = 0;
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            if(skill[i][0]==1) degree = -skill[i][5];
            else degree = skill[i][5];
            
            pref[r1][c1] += degree;
            pref[r1][c2+1] -= degree;
            pref[r2+1][c1] -= degree;
            pref[r2+1][c2+1] += degree;
        }
        
        for(int i=0; i<pref.length; i++){
            for(int j=0; j<pref[0].length-1; j++){
                pref[i][j+1] += pref[i][j];
            }
        }
        
        for(int i=0; i<pref.length-1; i++){
            for(int j=0; j<pref[0].length; j++){
                pref[i+1][j] += pref[i][j];
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]+pref[i][j]>=1) answer++;
            }
        }
        return answer;
    }
}
