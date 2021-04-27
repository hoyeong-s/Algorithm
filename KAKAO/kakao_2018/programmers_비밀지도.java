package kakao_2018;

public class programmers_비밀지도 {

	public static void main(String[] args) {
		int n = 5;
		int [] arr1 = {9, 20, 28, 18, 11};
		int [] arr2 = {30, 1, 21, 17, 28};
		
	}
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int [][] map = new int [n][n];
        map = makemap(n,arr1,map);
        map = makemap(n,arr2,map);
        
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1)
					sb.append("#");
				else
					sb.append(" ");
			}
			answer[i] = sb.toString();
		}
        	
        return answer;
    }
    
    static int [][]  makemap(int n, int [] arr, int [][] map) {
    	int [][] mapn = new int [n][n];
    	for(int i=0; i<n; i++) {
    		String str = Integer.toBinaryString(arr[i]);
    		int c = n-str.length();
    		for(int j=0; j<c; j++) {
    			if(map[i][j]==1) mapn[i][j]=1;
    		}
    		for(int j=0; j<str.length(); j++) {
    			int num = str.charAt(j)-'0';
    			if(map[i][j+c]==1 || num==1) mapn[i][j+c]=1;
    		}
    	}  	
    	return mapn;
    }
}
