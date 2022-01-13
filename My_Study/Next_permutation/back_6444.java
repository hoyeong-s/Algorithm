package Next_permutation;

import java.util.*;
import java.io.*;

public class back_6444 {
	static int N, cnt;
    static int [][] b;
    static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		solution(board,moves);
	}
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        N = board.length;
        b = board;
        
        for(int i=0; i<moves.length; i++){
            int col = moves[i]-1;
            int num = find(col);
            if(num!=-1) {
                remove(board[num][col]);
                board[num][col] = 0;
            }
        }
        
        return cnt;
    }
    
    private static int find(int col){
        for(int i=0; i<N; i++){
            if(b[i][col]!=0) return i;
        }
        return -1;
    }
    
    private static void remove(int num){
        if(!stack.isEmpty() && stack.peek()==num){
            stack.pop();
            cnt+=2;
        }
        else stack.push(num);
    }
}
