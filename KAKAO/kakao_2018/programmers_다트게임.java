package kakao_2018;

public class programmers_다트게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("1S*2T*3S"));
	}
	public static int solution(String dartResult) {
        int answer = make(dartResult);
        return answer;
    }
	
	static int make(String str) {
		int [] arr = new int [3];
		int sum=0, cur=0, save=0, idx=0;
		boolean flag = false; // 값을 배열에 삽입한적 있는지
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) { // 숫자일때
				if(flag) { // 저장값 배열에 삽입
					arr[idx++] = save;
					flag = false;
				}
				if(Character.isDigit(str.charAt(i+1))){ // 10인 경우
					cur = 10;
					i++;
					continue;
				}
				cur = str.charAt(i) - '0';
			}
			else if(Character.isAlphabetic(str.charAt(i))) { // 영어일때
				int cal = 1;
				if(str.charAt(i)=='D') {
					cal = 2;
				}
				else if(str.charAt(i)=='T') {
					cal = 3;
				}
				save = (int) Math.pow(cur, cal);
				flag = true;
				if(i==str.length()-1) arr[2] = save;
			}
			else {										// 상 받은 경우
				if(str.charAt(i)=='*') {
					if(idx==0) {
						arr[idx++] = 2*save;
					}
					else {
						arr[idx-1] *= 2;
						arr[idx++] = 2*save;
					}
				}
				else if(str.charAt(i)=='#') {
					arr[idx++] = -save;
				}
				flag = false;
			}
		}
		for(int x:arr) sum+=x;
		return sum;
	}
}
