package KAKAO_BLIND_RECRUITMENT_2020;

import java.util.HashMap;

public class 자물쇠와_열쇠 {
	static HashMap<String, Boolean> map = new HashMap<>(); 
	
	public static void main(String[] args) {
		int [][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};	
		int [][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key,lock));
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
        int len = key.length;
		
        for(int i=0; i<lock.length; i++) {
        	for(int j=0; j<lock[i].length; j++) {
        		if(lock[i][j]==0) {
        			String str = Integer.toString(i) + Integer.toString(j);
        			map.put(str, true);
        		}
        	}
        }
                
        if(map.size()==0) return true;
        
        int [][] ckey = new int [len][len];
        for(int i=0; i<4; i++) {
        	for(int j=0; j<len; j++) {
        		ckey = down(key,j);
            	if(comp(ckey,lock)) return true;
            	for(int l=1; l<len; l++) if(comp(left(ckey,l),lock)) return true;
            	for(int r=1; r<len; r++) if(comp(right(ckey,r),lock)) return true;
        	}
        	key = spin(key);
        }
        return false;
    }
	private static boolean comp(int [][] key, int [][] lock) {
		int cnt = 0;
		
		for(int x=0; x<=lock.length - key.length; x++) {
			outloop:for(int y=0; y<=lock.length - key.length; y++) {
				cnt = 0;
				
				for(int i=0; i<key.length; i++) {
					for(int j=0; j<key[i].length; j++) {
						if(key[i][j]==1) {
							if(lock[x+i][y+j]==1) continue outloop; // 돌기끼리 만나는 경우
		        			String str = Integer.toString(x+i) + Integer.toString(y+j);
							if(map.containsKey(str)) cnt++;
						}
					}
				}
				if(cnt == map.size()) return true;
			}
		}
		return false;
	}
	
	private static int [][] spin(int [][] key) {
		int [][] ckey = new int [key.length][key.length];
		
		int len = key.length-1;
		for(int i=0; i<key.length; i++) {
			for(int j=0; j<key[i].length; j++) {
				ckey[i][j] = key[len-j][i];
			}
		}
		return ckey;
	}
	
	private static int [][] right(int [][] key, int num) {
		int [][] ckey = new int [key.length][key.length];
		
		for(int i=0; i<key.length; i++) {
			for(int j=num; j<key[i].length; j++) {
				ckey[i][j] = key[i][j-num];
			}
		}
		return ckey;
	} 
	
	private static int [][] left(int [][] key, int num) {
		int [][] ckey = new int [key.length][key.length];
		
		for(int i=0; i<key.length; i++) {
			for(int j=0; j<key[i].length-num; j++) {
				ckey[i][j] = key[i][j+num];
			}
		}
		return ckey;
	}
	
	private static int [][] down(int [][] key, int num) {
		int [][] ckey = new int [key.length][key.length];
		
		for(int i=0; i<key.length-num; i++) {
			for(int j=0; j<key[i].length; j++) {
				ckey[i+num][j] = key[i][j];
			}
		}
		return ckey;
	}
	
}
