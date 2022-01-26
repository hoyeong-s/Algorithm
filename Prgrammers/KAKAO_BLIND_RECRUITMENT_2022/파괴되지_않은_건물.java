package KAKAO_BLIND_RECRUITMENT_2022;

class Solution {
    static int result = 0;
    static int [][] map;
    
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        result = board.length * board[0].length;
        map = board;
        
        for(int i=0; i<skill.length; i++){
            if(skill[i][0]==1) destroy(skill[i]);
            else build(skill[i]);
            
            // for(int k=0; k<map.length; k++){
            //     for(int j=0; j<map.length; j++){
            //         System.out.print(map[k][j]+" ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++)
                if(map[i][j]>=1) answer++;
        }
            
        return answer;
    }
    private static void destroy(int [] skill){
        int sr = skill[1];
        int sc = skill[2];
        int er = skill[3];
        int ec = skill[4];
        int point = skill[5];
        
        for(int i=sr; i<=er; i++){
            for(int j=sc; j<=ec; j++){
                map[i][j] -= point;
            }
        }
    }
    
    private static void build(int [] skill){
        int sr = skill[1];
        int sc = skill[2];
        int er = skill[3];
        int ec = skill[4];
        int point = skill[5];
        
        for(int i=sr; i<=er; i++){
            for(int j=sc; j<=ec; j++){
                map[i][j] += point;
            }
        }
    }
}
