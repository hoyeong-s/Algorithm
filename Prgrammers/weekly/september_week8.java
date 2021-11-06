package weekly;
import java.util.*;
import java.io.*;

public class september_week8 {
	static int [][] rsizes;
	public static void main(String[] args) {
		int [][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		int lng = 4;
		for (int i = 0; i < (1<<lng); i++) { 
        	for (int j = 0; j < lng; j++) {
        		if ((i & 1 << j) != 0) { 
        			System.out.print(j+" ");
        			} 
        		}
        	System.out.println();
        	}
	}
	public static int solution(int[][] sizes) {
        int answer = 0;
        int lng = sizes.length;
        
        rsizes  = new int [lng][2];
        for(int i=0; i<lng; i++) {
        	for(int j=1; j>=0; j--) {
        		rsizes[i][j] = sizes[i][1-j];
        	}
        }
        
        for (int i = 0; i < (1<<lng); i++) { 
        	for (int j = 0; j < lng; j++) {
        		if ((i & 1 << j) != 0) { 
        			System.out.print(j+" ");
        			} 
        		}
        	System.out.println();
        	}

        
        return answer;
    }
}
