
public class 문자열_압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababcdcdababcdcd";
		solution(s);
	}
	public static int solution(String s) {
        int answer = 0;
        
        for(int i=1; i<=s.length()/2; i++) {
        	find(i);
        }
        
        return answer;
    }
	private static int find(int num) {
		int size = 0;
		
		
		
		return size;
	}
}
